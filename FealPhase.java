import java.util.*;

public class FealPhase {

    public static HashMap<Object, Integer> k3Candidates = new HashMap<>();
    public static HashMap<Integer, Integer> functionCache = new HashMap<>();
    public static HashMap<Object, Integer> intermediateMatches = new HashMap<>();

    private static long plain0 = 0x0000000000000000L;
    private static long plain1 = 0x8080000080800000L;
    private static long plain2 = 0x1111111111111111L;
    private static long plain3 = plain2 ^ 0x8080000080800000L;
    private static long plain4 = 0x2222222222222222L;
    private static long plain5 = plain4 ^ 0x8080000080800000L;
    private static long plain6 = 0x3333333333333333L;
    private static long plain7 = plain6 ^ 0x8080000080800000L;

    private static long cipher0 = 0x0fdcf6447ff4090aL;
    private static long cipher1 = 0xb6de6c7c6e7eb3b2L;
    private static long cipher2 = 0x43b94fd4ce4ab516L;
    private static long cipher3 = 0x2a8f80ddffc45a9cL;
    private static long cipher4 = 0xeb8beef759019077L;
    private static long cipher5 = 0x2442789bfe40e596L;
    private static long cipher6 = 0x5365ae01bcbf74b7L;
    private static long cipher7 = 0x8d3ae738ba681d0dL;

    private static ArrayList<List<Long>> cipherBlocks = new ArrayList<>();

    public static void main(String[] args) {
        cipherBlocks.add(new ArrayList<>(Arrays.asList(cipher0, cipher1)));
        cipherBlocks.add(new ArrayList<>(Arrays.asList(cipher2, cipher3)));
        cipherBlocks.add(new ArrayList<>(Arrays.asList(cipher4, cipher5)));
        cipherBlocks.add(new ArrayList<>(Arrays.asList(cipher6, cipher7)));

        List<Integer> matchGroup1 = new ArrayList<>();
        List<Integer> matchGroup2 = new ArrayList<>();
        List<Integer> matchGroup3 = new ArrayList<>();
        List<Integer> matchGroup4 = new ArrayList<>();

        initialPhase(cipher0, cipher1, matchGroup1);
        initialPhase(cipher2, cipher3, matchGroup2);
        initialPhase(cipher4, cipher5, matchGroup3);
        initialPhase(cipher6, cipher7, matchGroup4);

        List<Integer> confirmedMatches = getCommonMatches(matchGroup1, matchGroup2, matchGroup3, matchGroup4);

        refinePhase(cipher0, cipher1, confirmedMatches);
        refinePhase(cipher2, cipher3, confirmedMatches);
        refinePhase(cipher4, cipher5, confirmedMatches);
        refinePhase(cipher6, cipher7, confirmedMatches);

        filterCandidates(4, k3Candidates);
        System.out.println(functionCache.size());
    }

    public static void filterCandidates(int expectedHits, HashMap<Object, Integer> candidates) {
        candidates.entrySet().removeIf(entry -> entry.getValue() != expectedHits);
        for (Map.Entry<Object, Integer> entry : candidates.entrySet()) {
            System.out.println("K3 Key Candidate: " + Integer.toHexString((int)entry.getKey()) + ", Matches: " + Integer.toHexString((int) entry.getValue()));
        }
    }

    public static int[] splitLongToInts(long block) {
        return new int[]{(int)(block >> 32), (int)block};
    }

    static byte rotateLeft2(byte val) {
        return (byte)(((val & 255) << 2) | ((val & 255) >>> 6));
    }

    static byte gFunction0(byte a, byte b) {
        return rotateLeft2((byte)((a + b) & 255));
    }

    static byte gFunction1(byte a, byte b) {
        return rotateLeft2((byte)((a + b + 1) & 255));
    }

    static int combineBytes(byte[] bytes, int offset) {
        return ((bytes[offset] & 255) << 24) | ((bytes[offset + 1] & 255) << 16) |
               ((bytes[offset + 2] & 255) << 8) | (bytes[offset + 3] & 255);
    }

    static void splitIntToBytes(int value, byte[] bytes, int offset) {
        bytes[offset] = (byte)(value >>> 24);
        bytes[offset + 1] = (byte)(value >>> 16);
        bytes[offset + 2] = (byte)(value >>> 8);
        bytes[offset + 3] = (byte)value;
    }

    static int roundFunction(int input) {
        byte[] inputBytes = new byte[4];
        byte[] outputBytes = new byte[4];
        splitIntToBytes(input, inputBytes, 0);
        outputBytes[1] = gFunction1((byte)((inputBytes[0] ^ inputBytes[1]) & 255), (byte)((inputBytes[2] ^ inputBytes[3]) & 255));
        outputBytes[0] = gFunction0(inputBytes[0], outputBytes[1]);
        outputBytes[2] = gFunction0(outputBytes[1], (byte)((inputBytes[2] ^ inputBytes[3]) & 255));
        outputBytes[3] = gFunction1(outputBytes[2], inputBytes[3]);
        return combineBytes(outputBytes, 0);
    }

    public static int transformM(int val) {
        int a0 = (val >> 24) & 0xFF;
        int a1 = (val >> 16) & 0xFF;
        int a2 = (val >> 8) & 0xFF;
        int a3 = val & 0xFF;
        return (0 << 24) | ((a0 ^ a1) << 16) | ((a2 ^ a3) << 8) | 0;
    }

    public static int memoizedFunction(int val) {
        return functionCache.computeIfAbsent(val, FealPhase::roundFunction);
    }

    public static void refinePhase(long block1, long block2, List<Integer> priorMatches) {
        int[] block1Parts = splitLongToInts(block1);
        int[] block2Parts = splitLongToInts(block2);
        int L0 = block1Parts[0], R0 = block1Parts[1];
        int L1 = block2Parts[0], R1 = block2Parts[1];
        int Y0 = L0 ^ R0;
        int Y1 = L1 ^ R1;
        int deltaZ = (L0 ^ L1) ^ 0x02000000;

        for (int partialKey : priorMatches) {
            int a0 = (partialKey >> 16) & 0xFF;
            int a1 = (partialKey >> 8) & 0xFF;
            for (int i = 0; i <= 0xFF; i++) {
                for (int j = 0; j <= 0xFF; j++) {
                    int fullKey = (i << 24) | ((a0 ^ i) << 16) | ((a1 ^ j) << 8) | j;
                    int result0 = Y0 ^ fullKey;
                    int result1 = Y1 ^ fullKey;
                    int out0 = memoizedFunction(result0);
                    int out1 = memoizedFunction(result1);
                    if ((out0 ^ out1) == deltaZ) {
                        k3Candidates.merge(fullKey, 1, Integer::sum);
                    }
                }
            }
        }
    }

    public static void initialPhase(long block1, long block2, List<Integer> resultMatches) {
        int[] parts1 = splitLongToInts(block1);
        int[] parts2 = splitLongToInts(block2);
        int L0 = parts1[0], R0 = parts1[1];
        int L1 = parts2[0], R1 = parts2[1];
        int Y0 = L0 ^ R0;
        int Y1 = L1 ^ R1;
        int delta = (L0 ^ L1) ^ 0x02000000;

        for (int i = 0; i <= 0xFF; i++) {
            for (int j = 0; j <= 0xFF; j++) {
                int testKey = (0 << 24) | (i << 16) | (j << 8);
                int temp0 = transformM(Y0 ^ testKey);
                int temp1 = transformM(Y1 ^ testKey);
                int f0 = memoizedFunction(temp0);
                int f1 = memoizedFunction(temp1);
                if (((f0 ^ f1) >> 8 & 0xFFFF) == ((delta >> 8) & 0xFFFF)) {
                    resultMatches.add(testKey);
                }
            }
        }
    }

    public static List<Integer> getCommonMatches(List<Integer> l1, List<Integer> l2, List<Integer> l3, List<Integer> l4) {
        List<Integer> matches = new ArrayList<>();
        for (Integer item : l1) {
            if (l2.contains(item) && l3.contains(item) && l4.contains(item)) {
                matches.add(item);
            }
        }
        return matches;
    }
}
