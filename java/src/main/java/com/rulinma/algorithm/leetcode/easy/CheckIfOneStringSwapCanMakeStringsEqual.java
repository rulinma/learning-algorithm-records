package com.rulinma.algorithm.leetcode.easy;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * <p>
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * <p>
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * <p>
 * https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal
 *
 * @author 马如林
 * @Data 2022/7/7 14:50
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        // diff
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                sb1.append(c1[i]);
                sb2.append(c2[i]);
            }
        }

        if (sb1.toString().length() == 2 && sb2.toString().length() == 2 && sb1.toString().equals(sb2.reverse().toString())) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        CheckIfOneStringSwapCanMakeStringsEqual checkIfOneStringSwapCanMakeStringsEqual = new CheckIfOneStringSwapCanMakeStringsEqual();

        String s1 = "bank";
        String s2 = "kanb";

        boolean rs = checkIfOneStringSwapCanMakeStringsEqual.areAlmostEqual(s1, s2);

        System.out.println(rs);
    }
}
