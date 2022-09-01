package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/1 16:59
 */
public class Test274 {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // 排序后累加和是否合理，不合理则返回false
        Arrays.sort(asteroids);

        long sum = mass;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > sum) {
                return false;
            }
            sum += asteroids[i];
        }

        return true;
    }

    /**
     * 2124. 检查是否所有 A 都在 B 之前
     */
    public boolean checkString(String s) {
        // 算法
        // a出现 b出现
        // 如果有a 也有b出现b则返回false
        // 如果有a 没有出现b，记录出现b；出现a，则不处理
        // 如果无a，出现a，如果前面有b，则返回false，否则则记录出现a，后续参考上述处理
        // 如果无a，出现b，则不处理
        char[] chars = s.toCharArray();
        boolean a = false;
        boolean b = false;

        for (char ch : chars) {
            if (a) {
                if (b && ch == 'a') {
                    return false;
                }
                if (ch == 'b') {
                    b = true;
                }
            }

            if (!b && ch == 'b') {
                b = true;
            }

            if (!a) {

                if (b && ch == 'a') {
                    return false;
                }

                if (ch == 'a') {
                    a = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
