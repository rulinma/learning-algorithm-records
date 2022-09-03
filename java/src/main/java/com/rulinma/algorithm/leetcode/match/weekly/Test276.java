package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/3 10:26
 */
public class Test276 {

    /**
     * 2138. 将字符串拆分为若干长度为 k 的组
     */
    public String[] divideString(String s, int k, char fill) {

        int len = s.length() / k;
        if (s.length() % k != 0) {
            len++;
        }

        String[] arr = new String[len];

        char[] chars = s.toCharArray();
        int i = 0;
        int j = 0;
        while (i + k <= chars.length) {
            String x = s.substring(i, i + k);
            arr[j++] = x;
            i = i + k;
        }
        // 最后一个处理
        if (s.length() % k != 0) {
            int mod = s.length() % k;
            // 补齐fill
            String r = s.substring(i);
            int remain = k - mod;
            StringBuilder sb = new StringBuilder();
            while (remain-- > 0) {
                sb.append(fill);
            }
            arr[j++] = r + sb.toString();
        }

        return arr;
    }

    public static void main(String[] args) {

//        String s = "abcdefghi";
//        int k = 3;
//        char fill = 'x';

        String s = "abcdefghij";
        int k = 3;
        char fill = 'x';

        Test276 test276 = new Test276();

        String[] rs = test276.divideString(s, k, fill);

        System.out.println(Arrays.toString(rs));
    }
}
