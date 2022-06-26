package com.rulinma.algorithm.leetcode.easy;

/**
 * 28. 实现 strStr()
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 链接：https://leetcode.cn/problems/implement-strstr
 *
 * @author 马如林
 * @Data 2022/6/26 10:57
 */
public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if (needle == null) {
            return 0;
        }

        // needle在haystack中进行递进查找，如果到末尾都能匹配，则查找到
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            // 从第一个位置开始匹配chars2，如果存在则找到。
            int j = i;
            int k = 0;
            while (k < chars2.length && (i + k < chars1.length)) {
                if (chars1[j++] != chars2[k++]) {
                    break;
                }

                if (k == chars2.length) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int strStr0(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        ImplementStrstr implementStrstr = new ImplementStrstr();
        String haystack = "mississippi";
        String needle = "issipi";
        int result = implementStrstr.strStr(haystack, needle);
        System.out.println(result);
    }

}
