package com.rulinma.algorithm.leetcode.match.weekly;

/**
 * @author 马如林
 * @Data 2022/9/25 18:18
 */
public class Test291 {

    /**
     * 2259. 移除指定数字得到的最大结果
     */
    public String removeDigit(String number, char digit) {
        String max = "";
        // 暴力直接替换，寻找最大值
        char[] chars = number.toCharArray();

        // 去除其中的某个digit
        for (int i = 0; i < number.length(); i++) {
            if (chars[i] == digit) {
                // 替换的字符串
                String s = number.substring(0, i) + number.substring(i + 1, number.length());
                if (s.compareTo(max) > 0) {
                    max = s;
                }
            }
        }

        return max;
    }


}
