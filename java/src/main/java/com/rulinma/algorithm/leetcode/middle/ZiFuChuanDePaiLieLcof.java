package com.rulinma.algorithm.leetcode.middle;

import java.util.*;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof
 *
 * @author 马如林
 * @Data 2022/8/9 13:41
 */
public class ZiFuChuanDePaiLieLcof {

    boolean[] vis = new boolean[10];

    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();

        // 回溯
        List<Character> current = new ArrayList<>();

        backtrace(s, current, list);

        String[] strings = new String[list.size()];
        int i = 0;
        for (String x : list) {
            strings[i++] = x.replaceAll(",", "").replaceAll(" ", "")
                    .replaceAll("\\[", "").replaceAll("]", "");
        }

        return strings;
    }

    public void backtrace(String s, List<Character> current, Set<String> rs) {
        // 停止条件
        if (current.size() == s.length()) {
            rs.add(current.toString());
            return;
        }

        // 继续
        char[] chars = s.toCharArray();
        //
        int i = 0;
        for (char ch : chars) {
            // 递进
            if (!vis[i]) {
                // continue
                current.add(ch);
                vis[i] = true;
                backtrace(s, current, rs);
                // 回退
                current.remove(current.size() - 1);
                vis[i] = false;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        ZiFuChuanDePaiLieLcof ziFuChuanDePaiLieLcof = new ZiFuChuanDePaiLieLcof();

        String[] rs = ziFuChuanDePaiLieLcof.permutation(s);
        for (String t : rs) {
            System.out.println(t);
        }
    }
}
