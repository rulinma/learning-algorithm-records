package com.rulinma.algorithm.leetcode.easy;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * https://leetcode.cn/problems/add-binary
 *
 * @author 马如林
 * @Data 2022/6/26 12:13
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int la = a.length();
        int lb = b.length();

        int t = 0;
        while (la >= 0 || lb >= 0 || t != 0) {
            if (la >= 0) {
                t += a.charAt(la--) - '0';
            }
            if (lb >= 0) {
                t += b.charAt(lb--) - '0';
            }
            sb.append(t % 2);
            t /= 2;
        }

        return sb.reverse().toString();
    }

}
