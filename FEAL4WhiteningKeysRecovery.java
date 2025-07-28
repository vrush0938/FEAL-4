import java.util.*;

public class FEAL4WhiteningKeysRecovery {
    static int rounds = 4;

    public static HashMap<Object, Integer> k4Candidates = new HashMap<Object, Integer>();
    public static HashMap<Object, Integer> k5Candidates = new HashMap<Object, Integer>();
    public static HashMap<Object, Integer> globalKeyCandidates = new HashMap<Object, Integer>();

    // Plaintext definitions
    public static final long PT0 = 0x1A2B3C4D5E6F7081L;
    public static final long PT1 = 0x9F8E7D6C5B4A3902L;
    public static final long PT2 = 0x1234567890ABCEF1L;
    public static final long PT3 = 0x0FEDCBA987654321L;
    public static final long PT4 = 0xABCDEFFEDCBA1234L;
    public static final long PT5 = 0x7890123456ACDEF1L;
    public static final long PT6 = 0x4567890ABCDEF234L;
    public static final long PT7 = 0xCDEF0123456789ABL;
    public static final long PT8 = 0x9876543210FEDCBAL;
    public static final long PT9 = 0x1122334455667788L;
    public static final long PT10 = 0x99AABBCCDDEEFF00L;
    public static final long PT11 = 0x00FFEEDDCCBBAA99L;
    public static final long PT12 = 0x13579BDF2468ACE0L;
    public static final long PT13 = 0xFACEB00CDEADBEAFL;
    public static final long PT14 = 0xCAFEBABEDEADC0DEL;
    public static final long PT15 = 0xFEEDFACEBADF00D5L;
    public static final long PT16 = 0x1BADB002FACEEAF0L;
    public static final long PT17 = 0xBADDCAFE13579ACEL;
    public static final long PT18 = 0xC0FFEE123456789AL;
    public static final long PT19 = 0x0BADF00DDEADBEEFL;
    public static final long PT20 = 0x1234567890ABCDEFL;
    public static final long PT21 = 0xFEEDFACECAFEBABEL;
    public static final long PT22 = 0xBADB0021FACEDEAFL;
    public static final long PT23 = 0x1234CDEF56789AB4L;
    public static final long PT24 = 0xACE13579BDF24680L;
    public static final long PT25 = 0xDEADBEEF13579BDFL;
    public static final long PT26 = 0xCAFEBABE09876543L;
    public static final long PT27 = 0xF00DFACEDEADC0DEL;
    public static final long PT28 = 0xBABEFACEBADC0FF1L;
    public static final long PT29 = 0x1337CAFEBABE0000L;
    public static final long PT30 = 0xBAADF00DCAFEBABEL;
    public static final long PT31 = 0x13579ACE2468BDF0L;

    // Ciphertext definitions
    public static final long CT0 = 0x83823efda40077feL;
    public static final long CT1 = 0x11945d160c68f6baL;
    public static final long CT2 = 0x8df64d7e8d2827a1L;
    public static final long CT3 = 0x0db3b2f70524526eL;
    public static final long CT4 = 0xdc609c2d62a1fba5L;
    public static final long CT5 = 0xdcd4cfb55c244cfcL;
    public static final long CT6 = 0x572ebb2f5dd429dfL;
    public static final long CT7 = 0x2bc919d888ab55ddL;
    public static final long CT8 = 0xc793453ec662a2f3L;
    public static final long CT9 = 0x87cb8c778e19d161L;
    public static final long CT10 = 0x27970c8c32cc4760L;
    public static final long CT11 = 0x399e8913faa24f7aL;
    public static final long CT12 = 0x842efcd3f35cbca9L;
    public static final long CT13 = 0x143e2fbb84990c2fL;
    public static final long CT14 = 0x6ca15a0e787c2202L;
    public static final long CT15 = 0x0d861b225c8b4253L;
    public static final long CT16 = 0x1af00e9e1603f275L;
    public static final long CT17 = 0x330a7289e179a3f7L;
    public static final long CT18 = 0xe815461dc57f1997L;
    public static final long CT19 = 0x7d148731fd10e455L;
    public static final long CT20 = 0xf43ae3eeb56e2bbfL;
    public static final long CT21 = 0xa4df544acd0bcfc3L;
    public static final long CT22 = 0xe5f41f3b19a626f3L;
    public static final long CT23 = 0x23494ae2cc430a12L;
    public static final long CT24 = 0x5e3c1aa903d2b8bcL;
    public static final long CT25 = 0xce75309e23088feeL;
    public static final long CT26 = 0x040dc1cd88f76f3eL;
    public static final long CT27 = 0x01572c3fcc3af4e0L;
    public static final long CT28 = 0xcc7899830ab289faL;
    public static final long CT29 = 0xbe97bc0c751e5678L;
    public static final long CT30 = 0x2a3c032d8a6b7bdeL;
    public static final long CT31 = 0xa0ca41b38d483b6cL;

    private static final ArrayList<List<Long>> ciphertextPairs = new ArrayList<List<Long>>();
    private static final ArrayList<List<Long>> plaintextPairs = new ArrayList<List<Long>>();

    public static void main(String[] args) {
        // Initialize ciphertext pairs
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT0, CT1)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT2, CT3)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT4, CT5)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT6, CT7)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT8, CT9)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT10, CT11)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT12, CT13)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT14, CT15)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT16, CT17)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT18, CT19)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT20, CT21)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT22, CT23)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT24, CT25)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT26, CT27)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT28, CT29)));
        ciphertextPairs.add(new ArrayList<>(Arrays.asList(CT30, CT31)));

        // Initialize plaintext pairs
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT0, PT1)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT2, PT3)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT4, PT5)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT6, PT7)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT8, PT9)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT10, PT11)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT12, PT13)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT14, PT15)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT16, PT17)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT18, PT19)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT20, PT21)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT22, PT23)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT24, PT25)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT26, PT27)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT28, PT29)));
        plaintextPairs.add(new ArrayList<>(Arrays.asList(PT30, PT31)));

        // Predefined key candidates
        int[] k3Options = {0x4f238976, 0xcfa309f6, 0x4f2309f6, 0xcfa38976};
        int[] k2Options = {0x9f22e41, 0x9f2aec1, 0x89722e41, 0x8972aec1};
        int[] k1Options = {
            0xc79f87fe, 0x471f077e, 0xc79f87fc, 0x471f077c,
            0xc59f87fe, 0x451f077e, 0xc59f87fc, 0x451f077c,
            0xc79f077e, 0x471f87fe, 0xc79f077c, 0x471f87fc,
            0xc59f077e, 0x451f87fe, 0xc59f077c, 0x451f87fc
        };
        int[] k0Options = {
            0x98c2148, 0x890ca1c8, 0x98c214a, 0x890ca1ca, 0x8b0ca1c8,
            0xb8c2148, 0x8b0ca1ca, 0xb8c214a, 0x98ca1c8, 0x890c2148,
            0x98ca1ca, 0x890c214a, 0x8b0c2148, 0xb8ca1c8, 0x8b0c214a, 0xb8ca1ca
        };

        // Process key combinations
        for (int k3 : k3Options) {
            for (int k2 : k2Options) {
                for (int k1 : k1Options) {
                    for (int k0 : k0Options) {
                        recoverWhiteningKeys(CT0, CT1, k3, k2, k1, PT1, PT2, k0);
                    }
                }
            }
        }

        // Collect results
        List<Integer> finalK4 = new ArrayList<>();
        List<Integer> finalK5 = new ArrayList<>();

        for (Object key : k4Candidates.keySet()) {
            if (key instanceof Integer) {
                finalK4.add((Integer) key);
                System.out.println("Possible K4: " + Integer.toHexString((Integer) key));
            }
        }
        
        System.out.println("\n\n");
        
        for (Object key : k5Candidates.keySet()) {
            if (key instanceof Integer) {
                finalK5.add((Integer) key);
                System.out.println("Possible K5: " + Integer.toHexString((Integer) key));
            }
        }
    }

    // Key recovery logic
    public static void recoverWhiteningKeys(long ciphertext0, long ciphertext1, long k3, long k2, long k1, long plaintext1, long plaintext2, long k0) {
        long y0, y1, l0, l1, r0, r1;

        int[] parts0 = splitTo32Bits(ciphertext0);
        int[] parts1 = splitTo32Bits(ciphertext1);

        l0 = parts0[0];
        r0 = parts0[1];
        l1 = parts1[0];
        r1 = parts1[1];

        // Process first ciphertext
        y0 = l0 ^ r0;
        long prev_y0 = y0;
        y0 = y0 ^ k3;
        y0 = f((int) y0);
        y0 = y0 ^ l0;
        long k2Prev_y0 = y0;
        y0 = y0 ^ k2;
        y0 = f((int) y0);
        y0 = prev_y0 ^ y0;
        long k1Prev_y0 = y0;
        y0 = y0 ^ k1;
        y0 = f((int) y0);
        y0 = k2Prev_y0 ^ y0;
        long k0Prev_y0 = y0;
        y0 = y0 ^ k0;
        y0 = f((int) y0);
        y0 = y0 ^ k1Prev_y0;
        long L0 = y0;
        long R0 = k0Prev_y0 ^ L0;

        // Process second ciphertext
        y1 = l1 ^ r1;
        long prev_y1 = y1;
        y1 = y1 ^ k3;
        y1 = f((int) y1);
        y1 = y1 ^ l1;
        long k2Prev_y1 = y1;
        y1 = y1 ^ k2;
        y1 = f((int) y1);
        y1 = prev_y1 ^ y1;
        long k1Prev_y1 = y1;
        y1 = y1 ^ k1;
        y1 = f((int) y1);
        y1 = k2Prev_y1 ^ y1;
        long k0Prev_y1 = y1;
        y1 = y1 ^ k0;
        y1 = f((int) y1);
        y1 = y1 ^ k1Prev_y1;
        long L1 = y1;
        long R1 = k0Prev_y1 ^ L1;

        // Compare with plaintext to get K4/K5 candidates
        int[] plainParts = splitTo32Bits(plaintext1);
        int leftValue = (int) (plainParts[0] ^ L0);
        int rightValue = (int) (plainParts[1] ^ R0);

        k4Candidates.put(leftValue, 1);
        k5Candidates.put(rightValue, 1);
    }

    // Helper methods
    public static int[] splitTo32Bits(long input) {
        int high = (int) (input >> 32);
        int low = (int) input;
        return new int[]{high, low};
    }

    public static int f(int input) {
        byte[] x = new byte[4];
        byte[] y = new byte[4];
        unpack(input, x, 0);
        y[1] = g1((byte) ((x[0] ^ x[1]) & 255), (byte) ((x[2] ^ x[3]) & 255));
        y[0] = g0((byte) (x[0] & 255), (byte) (y[1] & 255));
        y[2] = g0((byte) (y[1] & 255), (byte) ((x[2] ^ x[3]) & 255));
        y[3] = g1((byte) (y[2] & 255), (byte) (x[3] & 255));
        return pack(y, 0);
    }

    static byte rot2(byte x) {
        return (byte) (((x & 255) << 2) | ((x & 255) >>> 6));
    }

    static byte g0(byte a, byte b) {
        return rot2((byte) ((a + b) & 255));
    }

    static byte g1(byte a, byte b) {
        return rot2((byte) ((a + b + 1) & 255));
    }

    static int pack(byte[] b, int startindex) {
        return (b[startindex + 3] & 255) | ((b[startindex + 2] & 255) << 8) | 
               ((b[startindex + 1] & 255) << 16) | ((b[startindex] & 255) << 24);
    }

    static void unpack(int a, byte[] b, int startindex) {
        b[startindex] = (byte) (a >>> 24);
        b[startindex + 1] = (byte) (a >>> 16);
        b[startindex + 2] = (byte) (a >>> 8);
        b[startindex + 3] = (byte) a;
    }

    // Other helper methods
    public static boolean compareArrays(byte[] array1, byte[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static void k3Cleaning(int matches, HashMap<Object, Integer> k3) {
        k3.entrySet().removeIf(entry -> entry.getValue() != matches);
        for (Map.Entry<Object, Integer> entry : k3.entrySet()) {
            System.out.println("Key: " + Integer.toHexString((int) entry.getKey()) + 
                              ", Value: " + Integer.toHexString(entry.getValue()));
        }
    }

    public static int M(int A) {
        int a0 = (A >> 24) & 0xFF;
        int a1 = (A >> 16) & 0xFF;
        int a2 = (A >> 8) & 0xFF;
        int a3 = A & 0xFF;
        int z = 0x00;
        int b1 = a0 ^ a1;
        int b2 = a2 ^ a3;
        return (z << 24) | (b1 << 16) | (b2 << 8) | z;
    }

    static void encrypt(byte data[], int key[]) {
        int left, right, temp;
        left = pack(data, 0) ^ key[4];
        right = left ^ pack(data, 4) ^ key[5];
        for (int i = 0; i < rounds; i++) {
            temp = right;
            right = left ^ f(right ^ key[i]);
            left = temp;
        }
        left ^= right;
        unpack(right, data, 0);
        unpack(left, data, 4);
    }

    static void decrypt(byte data[], int key[]) {
        int left, right, temp;
        right = pack(data, 0);
        left = right ^ pack(data, 4);
        for (int i = 0; i < rounds; i++) {
            temp = left;
            left = right ^ f(left ^ key[rounds - 1 - i]);
            right = temp;
        }
        right ^= left;
        left ^= key[4];
        right ^= key[5];
        unpack(left, data, 0);
        unpack(right, data, 4);
    }

    public static List<Integer> findMatchingValues(List<Integer> list1, List<Integer> list2,
                                                   List<Integer> list3, List<Integer> list4) {
        List<Integer> matchingValues = new ArrayList<>();
        for (Integer value : list1) {
            if (list2.contains(value) && list3.contains(value) && list4.contains(value)) {
                matchingValues.add(value);
            }
        }
        return matchingValues;
    }
}