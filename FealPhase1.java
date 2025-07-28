import java.util.*;

public class FealPhase1 {

    public static HashMap<Object, Integer> candidateK2 = new HashMap<>();
    public static HashMap<Object, Integer> prelimK2 = new HashMap<>();
    public static HashMap<Object, Integer> fealCache = new HashMap<>();

    public static long pt0 = 0x0000000000000000L;
    public static long pt1 = 0x6060000060600000L;
    public static long pt2 = 0x1131111111111111L;
    public static long pt3 = pt2 ^ 0x6060000060600000L;
    public static long pt4 = 0x2223222222222222L;
    public static long pt5 = pt4 ^ 0x6060000060600000L;
    public static long pt6 = 0x3333633333333333L;
    public static long pt7 = pt6 ^ 0x6060000060600000L;
    public static long pt8 = 0x0000000000000111L;
    public static long pt9 = pt8 ^ 0x6060000060600000L;
    public static long pt10 = 0x113ab111111111abL;
    public static long pt11 = pt10 ^ 0x6060000060600000L;
    public static long pt12 = 0xccc3222222ccc222L;
    public static long pt13 = pt12 ^ 0x6060000060600000L;
    public static long pt14 = 0xf3ff63ff3333ff33L;
    public static long pt15 = pt14 ^ 0x6060000060600000L;
    public static long pt16 = 0xF000000000BBB000L;
    public static long pt17 = pt16 ^ 0x6060000060600000L;
    public static long pt18 = 0x1131111111111111L;
    public static long pt19 = pt18 ^ 0x6060000060600000L;
    public static long pt20 = 0x2223222aaa222222L;
    public static long pt21 = pt20 ^ 0x6060000060600000L;
    public static long pt22 = 0x333363bbb3333333L;
    public static long pt23 = pt22 ^ 0x6060000060600000L;
    public static long pt24 = 0x00000ccc03300111L;
    public static long pt25 = pt24 ^ 0x6060000060600000L;
    public static long pt26 = 0x113ab111444441abL;
    public static long pt27 = pt26 ^ 0x6060000060600000L;
    public static long pt28 = 0xc909892222ccc222L;
    public static long pt29 = pt28 ^ 0x6060000060600000L;
    public static long pt30 = 0xf3f123453333ff33L;
    public static long pt31 = pt30 ^ 0x6060000060600000L;

    private static long ct0 = 0x0fdcf6447ff4090aL;
    private static long ct1 = 0x45bcd45f5bfa2331L;
    private static long ct2 = 0x1b2de4c9d6c856b9L;
    private static long ct3 = 0x710dc4c8f2864e98L;
    private static long ct4 = 0x6cf7f90158c59357L;
    private static long ct5 = 0x46e3c56f248f47daL;
    private static long ct6 = 0x006db17d4cdf30aeL;
    private static long ct7 = 0xdb6d9079c54539caL;
    private static long ct8 = 0x6f7933b2b3ff60f3L;
    private static long ct9 = 0x077953b0c19d18d1L;
    private static long ct10 = 0xab7eafcac032e019L;
    private static long ct11 = 0x6bfc77eb12da2098L;
    private static long ct12 = 0x917c08486071d4afL;
    private static long ct13 = 0x2f49d150dcde6514L;
    private static long ct14 = 0x99e686430c765eb9L;
    private static long ct15 = 0xd3b24899207c6947L;
    private static long ct16 = 0xb4d65159539a7946L;
    private static long ct17 = 0x2ed6b15acbc041a5L;
    private static long ct18 = 0x1b2de4c9d6c856b9L;
    private static long ct19 = 0x710dc4c8f2864e98L;
    private static long ct20 = 0x0f5763293a83d645L;
    private static long ct21 = 0x6978241b1e314ca0L;
    private static long ct22 = 0x816bde9284400164L;
    private static long ct23 = 0x4d8e4f40fed37855L;
    private static long ct24 = 0xbdad63037cef1263L;
    private static long ct25 = 0xd7a1b4512489ad92L;
    private static long ct26 = 0x3b811b01d9b8fd8fL;
    private static long ct27 = 0xc081bb0378da55adL;
    private static long ct28 = 0xd89b94234a6fb292L;
    private static long ct29 = 0x5e9a323ace040c2bL;
    private static long ct30 = 0x2811013278187b5aL;
    private static long ct31 = 0xdf1452f8fd670071L;

    private static final ArrayList<List<Long>> blockPairs = new ArrayList<>();

    public static void main(String[] args) {
        blockPairs.add(new ArrayList<>(Arrays.asList(ct0, ct1)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct2, ct3)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct4, ct5)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct6, ct7)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct8, ct9)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct10, ct11)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct12, ct13)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct14, ct15)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct16, ct17)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct18, ct19)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct20, ct21)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct22, ct23)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct24, ct25)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct26, ct27)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct28, ct29)));
        blockPairs.add(new ArrayList<>(Arrays.asList(ct30, ct31)));

        int[] knownK3 = {0x4f238976, 0xcfa309f6, 0x4f2309f6, 0xcfa38976};

        for (int k3 : knownK3) {
            for (List<Long> pair : blockPairs) {
                initialPhase(pair.get(0), pair.get(1), k3, prelimK2);
            }
        }

        filterMap(24, prelimK2);

        List<Integer> refinedK2Inputs = new ArrayList<>();
        for (Object key : prelimK2.keySet()) {
            if (key instanceof Integer) refinedK2Inputs.add((Integer) key);
        }

        for (int k3 : knownK3) {
            for (List<Long> pair : blockPairs) {
                refinedPhase(pair.get(0), pair.get(1), k3, refinedK2Inputs);
            }
        }

        filterMap(16, candidateK2);

        Map.Entry<Object, Integer> best = null;
        for (Map.Entry<Object, Integer> entry : candidateK2.entrySet()) {
            if (best == null || entry.getValue() > best.getValue()) {
                best = entry;
            }
        }

        if (best != null) {
            System.out.println("Final likely K2: " + Integer.toHexString((int) best.getKey()));
            System.out.println("Hit Count: " + best.getValue());
        }
    }
    public static void filterMap(int requiredHits, HashMap<Object, Integer> map) {
        map.entrySet().removeIf(entry -> entry.getValue() != requiredHits);
        System.out.println("Filter complete with threshold: " + requiredHits);

        for (Map.Entry<Object, Integer> entry : map.entrySet()) {
            System.out.println("Candidate Key: " + Integer.toHexString((int) entry.getKey()) +
                               ", Count: " + entry.getValue());
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

    public static void initialPhase(long cip0, long cip1, long key, HashMap<Object, Integer> outputMap) {
    long y0, y1, z_dash, l0, l1, r0, r1;

    int[] p0_splits = splitTo32Bits(cip0);
    int[] p1_splits = splitTo32Bits(cip1);

    l0 = p0_splits[0];
    r0 = p0_splits[1];

    l1 = p1_splits[0];
    r1 = p1_splits[1];

    y0 = l0 ^ r0;
    long prev_y0 = y0;
    y0 = y0 ^ key;
    y0 = f((int) y0);
    y0 = y0 ^ l0;

    y1 = l1 ^ r1;
    long prev_y1 = y1;
    y1 = y1 ^ key;
    y1 = f((int) y1);
    y1 = y1 ^ l1;

    z_dash = (prev_y0 ^ prev_y1) ^ 0x60600000;

    for (int a0 = 0x00; a0 <= 0xFF; a0++) {
        for (int a1 = 0x00; a1 <= 0xFF; a1++) {
            int A = (0) | (a0 << 16) | (a1 << 8);
            int temp1 = M((int) y0 ^ A);
            int temp2 = M((int) y1 ^ A);

            int Q0 = f(temp1);
            int Q1 = f(temp2);

            int extractedBits = (Q0 ^ Q1) >> 8 & 0xFFFF;
            int Z_dash_bits = (int) ((z_dash >> 8) & 0xFFFF);

            if (extractedBits == Z_dash_bits) {
                int value = (a0 << 16) | (a1 << 8);
                outputMap.merge(value, 1, Integer::sum);
            }
        }
    }
}
    public static void refinedPhase(long block1, long block2, long k3, List<Integer> survivors) {
        long left0, right0, left1, right1;
        long y0, y1, zDiff;

        int[] split0 = splitTo32Bits(block1);
        int[] split1 = splitTo32Bits(block2);

        left0 = split0[0];
        right0 = split0[1];
        left1 = split1[0];
        right1 = split1[1];

        y0 = left0 ^ right0 ^ k3;
        long preY0 = y0;
        y0 = f((int) y0) ^ left0;

        y1 = left1 ^ right1 ^ k3;
        long preY1 = y1;
        y1 = f((int) y1) ^ left1;

        zDiff = (preY0 ^ preY1) ^ 0x60600000;

        for (Integer s : survivors) {
            int a0 = (s >> 16) & 0xFF;
            int a1 = (s >> 8) & 0xFF;

            for (int c0 = 0x00; c0 <= 0xFF; c0++) {
                for (int c1 = 0x00; c1 <= 0xFF; c1++) {
                    int D = (c0 << 24) | ((a0 ^ c0) << 16) | ((a1 ^ c1) << 8) | c1;
                    int z0 = computeCachedF((int) (y0 ^ D));
                    int z1 = computeCachedF((int) (y1 ^ D));

                    if ((z0 ^ z1) == zDiff) {
                        candidateK2.merge(D, 1, Integer::sum);
                    }
                }
            }
        }
    }

    public static int computeCachedF(int input) {
        return fealCache.computeIfAbsent(input, key -> f((int) key));
    }
    // Other methods remain unchanged but renamed as required
    // (Not displayed here due to length — just variable/method renaming)

    
    public static int[] splitTo32Bits(long input) {
    int high = (int) (input >> 32);
    int low = (int) input;
    return new int[]{high, low};
}
public static int f(int input) {
    byte[] x = new byte[4];
    byte[] y = new byte[4];

    unpack(input, x, 0);

    y[1] = g1((byte)((x[0]^x[1]) & 0xFF), (byte)((x[2]^x[3]) & 0xFF));
    y[0] = g0(x[0], y[1]);
    y[2] = g0(y[1], (byte)(x[2] ^ x[3]));
    y[3] = g1(y[2], x[3]);

    return pack(y, 0);
}
public static byte rot2(byte x) {
    return (byte)(((x & 0xFF) << 2) | ((x & 0xFF) >>> 6));
}

public static byte g0(byte a, byte b) {
    return rot2((byte)((a + b) & 0xFF));
}

public static byte g1(byte a, byte b) {
    return rot2((byte)((a + b + 1) & 0xFF));
}

public static int pack(byte[] b, int startindex) {
    return ((b[startindex + 3] & 0xFF) |
           ((b[startindex + 2] & 0xFF) << 8) |
           ((b[startindex + 1] & 0xFF) << 16) |
           ((b[startindex] & 0xFF) << 24));
}

public static void unpack(int a, byte[] b, int startindex) {
    b[startindex] = (byte)(a >>> 24);
    b[startindex + 1] = (byte)(a >>> 16);
    b[startindex + 2] = (byte)(a >>> 8);
    b[startindex + 3] = (byte)a;
}

}
