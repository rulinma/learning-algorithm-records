package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/4 12:33
 */
public class Test309 {

    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        // 滑动区间
        // dp[i] 表示以i为结尾的最长优雅子数组的长度
        for (int i = 1; i < nums.length; i++) {
            // dp[i] 和 dp[i-1]取最大值，放到dp[i]中
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= i - dp[i - 1]; j--) {
                // 检查其后续的最长优雅子数组
                if ((nums[i] & nums[j]) != 0) {
                    dp[i] = i - j;
                    break;
                }
            }

            max = Math.max(dp[i], max);
        }

        return max;
    }

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
        int[] nums = new int[]{1, 3, 8, 48, 10};

        Test309 test309 = new Test309();
        int rs = test309.longestNiceSubarray(nums);
        System.out.println(rs);
    }
}
