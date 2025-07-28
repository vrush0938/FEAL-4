import java.util.*;

public class FealPhases2 {

    public static HashMap<Object, Integer> k1 = new HashMap<Object, Integer>();
    public static HashMap<Object, Integer> k1_primary = new HashMap<Object, Integer>();

    public static HashMap<Object, Integer> globalKeys = new HashMap<Object, Integer>();


    public static long p0 = 0x0000000000000000L;
    public static long p1 = 0x6061212c60600abcL;
    public static long p2 = 0x1131111111111111L;
    public static long p3 = p2 ^ 0x6061212c60600abcL;
    public static long p4 = 0x2223222222222222L;
    public static long p5 = p4 ^ 0x6061212c60600abcL;
    public static long p6 = 0x3333633333333333L;
    public static long p7 = p6 ^ 0x6061212c60600abcL;
    public static long p8 = 0x0000000000000111L;
    public static long p9 = p8 ^ 0x6061212c60600abcL;
    public static long p10 = 0x113ab111111111abL;
    public static long p11 = p10 ^ 0x6061212c60600abcL;
    public static long p12 = 0xccc3222222ccc222L;
    public static long p13 = p12 ^ 0x6061212c60600abcL;
    public static long p14 = 0xf3ff63ff3333ff33L;
    public static long p15 = p14 ^ 0x6061212c60600abcL;

    public static long p16 = 0xF000000000BBB000L;
    public static long p17 = p16 ^ 0x6061212c60600abcL;
    public static long p18 = 0x1131111111111111L;
    public static long p19 = p18 ^ 0x6061212c60600abcL;
    public static long p20 = 0x2223222aaa222222L;
    public static long p21 = p20 ^ 0x6061212c60600abcL;
    public static long p22 = 0x333363bbb3333333L;
    public static long p23 = p22 ^ 0x6061212c60600abcL;
    public static long p24 = 0x00000ccc03300111L;
    public static long p25 = p24 ^ 0x6061212c60600abcL;
    public static long p26 = 0x113ab111444441abL;
    public static long p27 = p26 ^ 0x6061212c60600abcL;
    public static long p28 = 0xc909892222ccc222L;
    public static long p29 = p28 ^ 0x6061212c60600abcL;
    public static long p30 = 0xf3f123453333ff33L;
    public static long p31 = p30 ^ 0x6061212c60600abcL;

    public static long c0 = 0x0fdcf6447ff4090aL;   // 11546748615803289802
    public static long c1 = 0xec4c3cdb9e6d9c5aL;   // 17021749140407392634
    public static long c2 = 0x1b2de4c9d6c856b9L;   // 12893416288920857337
    public static long c3 = 0xf2c521aff1125c03L;   // 17401387278164598339
    public static long c4 = 0x6cf7f90158c59357L;   // 7847959282447661047
    public static long c5 = 0x53d4dbac7b76db2eL;   // 6038991186816964350
    public static long c6 = 0x006db17d4cdf30aeL;   // 12517606072754030
    public static long c7 = 0x6b798d951bc68934L;   // 7849350162272126444
    public static long c8 = 0x6f7933b2b3ff60f3L;   // 8035882881896775875
    public static long c9 = 0xc4c0355b4136804dL;   // 14252445696333478509
    public static long c10 = 0xab7eafcac032e019L;   // 12331210409167936281
    public static long c11 = 0x2fb70926c3771ac6L;   // 3444016264536142848
    public static long c12 = 0x917c08486071d4afL;   // 10492323952271378479
    public static long c13 = 0x4b920cc7536b4e0cL;   // 5414726269876976764
    public static long c14 = 0x99e686430c765eb9L;   // 11096023348592943033
    public static long c15 = 0xf44c31e2d0f4b805L;   // 17653527805519910277
    public static long c16 = 0xb4d65159539a7946L;   // 13040140040265195718
    public static long c17 = 0xd2e1b648b933f80eL;   // 15118188163247223470
    public static long c18 = 0x1b2de4c9d6c856b9L;   // 12893416288920857337
    public static long c19 = 0xf2c521aff1125c03L;   // 17401387278164598339
    public static long c20 = 0x0f5763293a83d645L;   // 11481426784243921477
    public static long c21 = 0x1aa316cd3dc39787L;   // 1910162042620668255
    public static long c22 = 0x816bde9284400164L;   // 930211508467102116
    public static long c23 = 0x2a8f7a83a2da2c9cL;   // 3037790211312041228
    public static long c24 = 0xbdad63037cef1263L;   // 13794668751791632099
    public static long c25 = 0x071edb33eb74a167L;   // 509227949687428935
    public static long c26 = 0x3b811b01d9b8fd8fL;   // 4286777446491468247
    public static long c27 = 0xdae106536d7ebdb0L;   // 15779811082285809872
    public static long c28 = 0xd89b94234a6fb292L;   // 15553174767071336530
    public static long c29 = 0xbafc97a95ee8183fL;   // 13464964376346001055
    public static long c30 = 0x2811013278187b5aL;   // 2906328470150852426
    public static long c31 = 0xc0c8865e691944e0L;   // 13838756934545613280

    private static final ArrayList<List<Long>> cipherTexts = new ArrayList<List<Long>>();

    public static void main(String[] args) {

        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c0, (long) c1)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c2, (long) c3)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c4, (long) c5)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c6, (long) c7)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c8, (long) c9)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c10, (long) c11)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c12, (long) c13)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c14, (long) c15)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c16, (long) c17)));

        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c18, (long) c19)));

        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c20, (long) c21)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c22, (long) c23)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c24, (long) c25)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c26, (long) c27)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c28, (long) c29)));
        cipherTexts.add(new ArrayList<>(Arrays.asList((long) c30, (long) c31)));


        int[] k3Values = {0x4f238976, 0xcfa309f6, 0x4f2309f6, 0xcfa38976};
        int[] k2Values = {
                0x9f22e41,
                0x9f2aec1,
                0x89722e41,
                0x8972aec1
        };

        for (int val : k3Values) {
            for (int k2Val : k2Values) {
                //System.out.println(Integer.toHexString(val));

                for (List<Long> list : cipherTexts) {

                    long temp1, temp2;
                    temp1 = list.get(0);
                    temp2 = list.get(1);

                    primaryPhase(temp1, temp2, val, k1_primary, k2Val);
                }
                //for ()
            }
        }
        //System.out.println(k1_primary.size());


       for (Map.Entry<Object, Integer> entry : k1_primary.entrySet()) {
            System.out.println("Key: " + Integer.toHexString((int)entry.getKey()) + ", Value: " + entry.getValue());
        }


        k3Cleaning(21, k1_primary);


        List<Integer> primarySurvivors = new ArrayList<>();


        for (Object key : k1_primary.keySet()) {
            if (key instanceof Integer) {
                primarySurvivors.add((Integer) key);
                //System.out.println(Integer.toHexString((Integer) key));
            }
        }

        for (int val : k3Values){
            for (int k2Val : k2Values) {
                //System.out.println(Integer.toHexString(val));

                for (List<Long> list : cipherTexts) {

                    long temp1, temp2;
                    temp1 = list.get(0);
                    temp2 = list.get(1);

                    secondaryPhase(temp1, temp2, val, primarySurvivors, k2Val);

                }
            }
        }


        //System.out.println(k1.size());
        Map.Entry<Object, Integer> maxEntry = null;

        for (Map.Entry<Object, Integer> entry : k1.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        if (maxEntry != null) {
            System.out.println("Key with maximum value: " + maxEntry.getKey());
            System.out.println("Maximum value: " + maxEntry.getValue());
        }

        k3Cleaning(16, k1);

    }


    public static void k3Cleaning(int matches, HashMap<Object, Integer> k3)
    {

        // Remove entries that don't have value 4
        k3.entrySet().removeIf(entry -> entry.getValue() != matches);
        System.out.println("completed");

        for (Map.Entry<Object, Integer> entry : k3.entrySet()) {
            System.out.println("k2 possible candidates Key: " + Integer.toHexString((int)entry.getKey()) );
        }
    }


    public static int[] splitTo32Bits(long input) {
        int high = (int) (input >> 32);
        int low = (int) input;
        return new int[]{high, low};
    }

    static byte rot2(byte x) {
        return (byte)(((x&255)<<2)|((x&255)>>>6));
    }

    static byte g0(byte a,byte b) {
        return rot2((byte)((a+b)&255));
    }

    static byte g1(byte a,byte b) {
        return rot2((byte)((a+b+1)&255));
    }

    static int pack(byte[] b,int startindex) {
        /* pack 4 bytes into a 32-bit Word */
        return ((b[startindex+3]&255) |((b[startindex+2]&255)<<8)|((b[startindex+1]&255)<<16)|((b[startindex]&255)<<24));
    }

    static void unpack(int a,byte[] b,int startindex) {

        b[startindex]=(byte)(a>>>24);
        b[startindex+1]=(byte)(a>>>16);
        b[startindex+2]=(byte)(a>>>8);
        b[startindex+3]=(byte)a;
    }

    static int f(int input) {
        byte[] x = new byte[4];
        byte[] y = new byte[4];

        unpack(input,x,0);
        y[1]=g1((byte)((x[0]^x[1])&255),(byte)((x[2]^x[3])&255));
        y[0]=g0((byte)(x[0]&255),(byte)(y[1]&255));
        y[2]=g0((byte)(y[1]&255),(byte)((x[2]^x[3])&255));
        y[3]=g1((byte)(y[2]&255),(byte)(x[3]&255));
        return pack(y,0);
    }

    public static int M(int A) {
        // Extract bytes a0, a1, a2, and a3 from the 32-bit integer A
        int a0 = (A >> 24) & 0xFF;  // Extract the highest 8 bits (first byte)
        int a1 = (A >> 16) & 0xFF;  // Extract the next 8 bits
        int a2 = (A >> 8) & 0xFF;   // Extract the third 8 bits
        int a3 = A & 0xFF;          // Extract the lowest 8 bits (fourth byte)

        // Compute M(A) = (z, a0 ^ a1, a2 ^ a3, z)
        int z = 0x00;               // z is the all-zero byte
        int b1 = a0 ^ a1;           // Second byte
        int b2 = a2 ^ a3;           // Third byte

        // Construct the result by combining these bytes into a 32-bit integer
        int result = (z << 24) | (b1 << 16) | (b2 << 8) | z;
        return result;
    }


    public static void secondaryPhase(long cip0, long cip1,long key, List<Integer> primarySurvivors, long k2Val)
    {
        long y0, y1, z_dash, l0, l1, r0, r1;

        int[] p0_splits = splitTo32Bits(cip0);
        int[] p1_splits = splitTo32Bits(cip1);


        l0 = p0_splits[0];
        r0 = p0_splits[1];
/*        System.out.println("l0 " + Integer.toHexString((int) l0));
        System.out.println("r0 " + Integer.toHexString((int) r0));*/

        l1 = p1_splits[0];
        r1 = p1_splits[1];
/*        System.out.println("l1 " + Integer.toHexString((int) l1));
        System.out.println("r1 " + Integer.toHexString((int) r1));*/


        y0 = l0 ^ r0;
        long prev_y0 = y0;
        y0 = y0 ^ key;
        y0 = f((int) y0);
        y0 = y0 ^ l0;
        long k2Prev_y0 = y0;
        y0 = y0 ^ k2Val;
        y0 = f((int) y0);
        y0 = prev_y0 ^ y0;


        y1 = l1 ^ r1;
        long prev_y1 = y1;
        y1 = y1 ^ key;
        y1 = f((int) y1);
        y1 = y1 ^ l1;
        long k2Prev_y1 = y1;
        y1 = y1 ^ k2Val;
        y1 = f((int) y1);
        y1 = prev_y1 ^ y1;



/*
        System.out.println("y0 "+ Integer.toHexString((int) y0));
        System.out.println("y1 "+ Integer.toHexString((int) y1));*/

        //l_dash = l0 ^ l1;

        //System.out.println("ld "+ Integer.toHexString((int) l_dash));

        z_dash = (k2Prev_y0 ^ k2Prev_y1) ^ 0x00012b90;



        //System.out.println("zdash    "+ Integer.toHexString((int) z_dash)+"\n\n");




        for (Integer survivor : primarySurvivors)
        {
            int a1 = (survivor >> 8) & 0xFF;
            int a0 = (survivor >> 16) & 0xFF;


            for (int c0 = 0x00; c0 <= 0xFF; c0++) {
                for (int c1 = 0x00; c1 <= 0xFF; c1++) {
                    // Compute D
                    int D = (c0 << 24) | ((a0 ^ c0) << 16) | ((a1 ^ c1) << 8) | c1;


                    int temp1, temp2;

                    temp1 = (int) (y0 ^ D);
                    temp2 = (int) (y1 ^ D);;
                    int Z0, Z1;
                    Z0 = f(temp1);
                    Z1 = f(temp2);


                    if ((Z0 ^ Z1) == z_dash)
                    {


                        if(k1.containsKey(D))
                        {
                            int temp = k1.get(D)+1;
                            k1.put(D,temp);

                        }
                        else
                        {
                            k1.put(D, 1);
                        }
                    }
                }
            }
        }


    }

    public static int globalDictConstructor(long checkValue)
    {
        if(globalKeys.containsKey(checkValue))
        {
            return globalKeys.get(checkValue);
        }
        else
        {
            int temp;
            temp = f((int) checkValue);
            globalKeys.put(checkValue, temp);
            return globalKeys.get(checkValue);
        }
    }



    public static void primaryPhase(long cip0, long cip1, long key, HashMap<Object, Integer> matchingPairs, long k2Val)
    {
        long y0, y1, z_dash, l0, l1, r0, r1;

        int[] p0_splits = splitTo32Bits(cip0);
        int[] p1_splits = splitTo32Bits(cip1);


        l0 = p0_splits[0];
        r0 = p0_splits[1];
/*        System.out.println("l0 " + Integer.toHexString((int) l0));
        System.out.println("r0 " + Integer.toHexString((int) r0));*/
/*      System.out.println("l0 " + Integer.toHexString(p0_splits[0]));
        System.out.println("r0 " + Integer.toHexString(p0_splits[1]));*/


        l1 = p1_splits[0];
        r1 = p1_splits[1];
/*        System.out.println("l1 " + Integer.toHexString((int) l1));
        System.out.println("r1 " + Integer.toHexString((int) r1));*/


        y0 = l0 ^ r0;
        long prev_y0 = y0;
        y0 = y0 ^ key;
        y0 = f((int) y0);
        y0 = y0 ^ l0;
        long k2Prev_y0 = y0;
        y0 = y0 ^ k2Val;
        y0 = f((int) y0);
        y0 = prev_y0 ^ y0;


        y1 = l1 ^ r1;
        long prev_y1 = y1;
        y1 = y1 ^ key;
        y1 = f((int) y1);
        y1 = y1 ^ l1;
        long k2Prev_y1 = y1;
        y1 = y1 ^ k2Val;
        y1 = f((int) y1);
        y1 = prev_y1 ^ y1;




/*        System.out.println("y0 "+ Integer.toHexString((int) y0));
        System.out.println("y1 "+ Integer.toHexString((int) y1));*/

        //l_dash = l0 ^ l1;

        //System.out.println("ld "+ Integer.toHexString((int) l_dash));

        z_dash = (k2Prev_y0 ^ k2Prev_y1) ^ 0x00012b90;



        //System.out.println("zdash    "+ Integer.toHexString((int) z_dash)+"\n\n");


        //System.out.println(Integer.toHexString(M(0x12345678)));


        //middle16Finding(y0, y1,z_dash, matchingPairs);
        for (int a0 = 0x00; a0 <= 0xFF; a0++) {
            for (int a1 = 0x00; a1 <= 0xFF; a1++) {
                // Construct the 32-bit word A = (0x00, a0, a1, 0x00)
                int A = (0) | (a0 << 16) | (a1 << 8);

                // Calculate Q0 and Q1
                int temp1, temp2;
                temp1 = M((int) y0 ^ A);
                temp2 = M((int) y1 ^ A);
                int Q0, Q1;
                Q0 = globalDictConstructor(temp1);
                Q1 = globalDictConstructor(temp2);


                //int Q0 = f(M((int) y0) ^ A);
                //int Q1 = f(M((int) y1) ^ A);

                // XOR Q0 and Q1
                int xorResult = Q0 ^ Q1;

                // Extract bits 8 to 23 (16 bits) from xorResult
                int extractedBits = (xorResult >> 8) & 0xFFFF;
                int Z_dash_bits = (int) ((z_dash >> 8) & 0xFFFF);

                // Check if the extracted bits match Z' bits 8...23
                if (extractedBits == Z_dash_bits)
                {
                    // If they match, save or print (a0, a1)
                    int value = (0) | (a0 << 16) | (a1 << 8);
                    if (matchingPairs.containsKey(value)) {
                        int temp = matchingPairs.get(value);
                        matchingPairs.put(value, temp+1);
                    }
                    else
                    {
                        matchingPairs.put(value,1);
                    }
                    //System.out.printf("Matching pair found: (a0 = 0x%02X, a1 = 0x%02X)%n", a0, a1);
                }
            }
        }

    }



    public static List<Integer> findMatchingValues(List<Integer> list1, List<Integer> list2,
                                                   List<Integer> list3, List<Integer> list4)
    {
        List<Integer> matchingValues = new ArrayList<>();

        // Iterate over the first list and check if the element is in all other lists
        for (Integer value : list1) {
            if (list2.contains(value) && list3.contains(value) && list4.contains(value)) {
                matchingValues.add(value);
            }
        }

        return matchingValues;
    }
}
