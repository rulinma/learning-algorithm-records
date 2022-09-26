package com.rulinma.algorithm.leetcode.match.weekly;

/**
 * @author 马如林
 * @Data 2022/9/26 09:25
 */
public class Test292 {

    /**
     * 2264. 字符串中最大的 3 位相同数字
     */
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();

        StringBuilder sb = new StringBuilder();

        String max = "";
        int count = 1;
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                count = 1;
                sb = new StringBuilder();
                sb.append(chars[i]);
            } else {
                count++;
                sb.append(chars[i]);
                if (count == 3) {
                    if (max.compareTo(sb.toString()) < 0) {
                        max = sb.toString();
                    }
                    count = 1;
                    sb = new StringBuilder();
                    sb.append(chars[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
