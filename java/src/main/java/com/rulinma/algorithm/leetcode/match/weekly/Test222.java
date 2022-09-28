package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/26 11:22
 */
public class Test222 {

    /**
     * 面试题 17.09. 第 k 个数
     */
    public int getKthMagicNumber(int k) {
        int[] i = new int[]{3, 5, 7};
        int ans = 1;
        int j = 0;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        priorityQueue.add(1L);
        j = 1;

        while (j <= k) {
            long m = priorityQueue.poll();
            ans = (int) m;
            for (int x : i) {
                long r = m * x;
                if (set.add(r)) {
                    priorityQueue.add(r);
                }
            }
            j++;
        }

        return ans;
    }

    /**
     * 面试题 01.02. 判定是否互为字符重排
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] cnt = new int[26];

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        for (int i = 0; i < s1.length(); i++) {
            cnt[chars1[i] - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            cnt[chars2[i] - 'a']--;
            if (cnt[chars2[i] - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }


    public boolean CheckPermutation1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

//        for (int i = 0; i < s1.length(); i++) {
//            if (chars1[i] != chars2[i]) {
//                return false;
//            }
//        }
        return Arrays.equals(chars1, chars2);
//        return true;
    }

    /**
     * 1710. 卡车上的最大单元数
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int max = 0;
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return ((Integer) o2[1]).compareTo(o1[1]);
            }
        });

        int remain = truckSize;
        for (int[] b : boxTypes) {
            if (remain > 0) {
                if (remain - b[0] > 0) {
                    remain = remain - b[0];
                    max += b[0] * b[1];
                } else if (remain - b[0] == 0) {
                    remain = remain - b[0];
                    max += b[0] * b[1];
                    break;
                } else {
                    max += remain * b[1];
                    break;
                }
            } else if (remain == 0) {
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};

        Test222 test222 = new Test222();
//        int rs = test222.maximumUnits(boxTypes, 4);
//        System.out.println(rs);


    }

}
