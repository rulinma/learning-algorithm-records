package com.rulinma.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1876. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * <p>
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * <p>
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * <p>
 * 子字符串 是一个字符串中连续的字符序列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "xyzzaz"
 * 输出：1
 * 解释：总共有 4 个长度为 3 的子字符串："xyz"，"yzz"，"zza" 和 "zaz" 。
 * 唯一的长度为 3 的好子字符串是 "xyz" 。
 * 示例 2：
 * <p>
 * 输入：s = "aababcabc"
 * 输出：4
 * 解释：总共有 7 个长度为 3 的子字符串："aab"，"aba"，"bab"，"abc"，"bca"，"cab" 和 "abc" 。
 * 好子字符串包括 "abc"，"bca"，"cab" 和 "abc" 。
 * <p>
 * https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters
 *
 * @author 马如林
 * @Data 2022/7/1 09:40
 */
public class SubstringsOfSizeThreeWithDistinctCharacters {

    public int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2) && s.charAt(i + 1) != s.charAt(i + 2)) {
                res++;
            }
        }
        return res;
    }

    public int countGoodSubstrings1(String s) {
        // 1. 长度为3的字符串组合
        List<String> list = new ArrayList<>();
        // 2. 该字符串是好串
        if (s.length() < 3) {
            return 0;
        }

        int i = 0;
        int j = 3;
        while (i < s.length() - 2 && j <= s.length()) {
            list.add(s.substring(i, j));
            i++;
            j++;
        }

        int count = 0;
        for (String str : list) {
            if (goodString(str)) {
                count++;
            }
        }

        return count;
    }

    public boolean goodString(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }

        return true;
    }

    public static void main(String[] args) {
        SubstringsOfSizeThreeWithDistinctCharacters substringsOfSizeThreeWithDistinctCharacters = new SubstringsOfSizeThreeWithDistinctCharacters();
        String s = "xyzzaz";
        int result = substringsOfSizeThreeWithDistinctCharacters.countGoodSubstrings(s);
        System.out.println(result);
    }
}
