package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * https://leetcode.cn/problems/letter-case-permutation
 *
 * @author 马如林
 * @Data 2022/7/8 18:16
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c : S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    // 添加小写和大写
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n + i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i) {
                    ans.get(i).append(c);
                }
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb : ans) {
            finalans.add(sb.toString());
        }

        return finalans;
    }


    public static void main(String[] args) {
        String s = "a1b2";
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        List<String> rs = letterCasePermutation.letterCasePermutation(s);
        System.out.println(rs);
    }
}
