package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/4 12:33
 */
public class Test309 {

    /**
     * 6167. 检查相同字母间的距离
     */
    public boolean checkDistances(String s, int[] distance) {
        // 算法
        // 1. 设置每个字母出现的位置
        // 2. 第2次出现时，设置为距离

        char[] chars = s.toCharArray();
        int[] d = new int[26];

        Arrays.fill(d, -1);

        int i = 0;
        for (char ch : chars) {
            if (d[ch - 'a'] == -1) {
                d[ch - 'a'] = i;
            } else {
                d[ch - 'a'] = i - d[ch - 'a'] - 1;
            }
            i++;
        }

        // 3. 距离>=0的检查distance中是否一致
        for (int j = 0; j < d.length; j++) {
            if (d[j] != -1 && d[j] != distance[j]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

    }
}
