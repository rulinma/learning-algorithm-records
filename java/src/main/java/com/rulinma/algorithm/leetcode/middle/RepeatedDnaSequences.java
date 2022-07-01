package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. 重复的DNA序列
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * <p>
 * https://leetcode.cn/problems/repeated-dna-sequences
 *
 * @author 马如林
 * @Data 2022/7/1 17:21
 */
public class RepeatedDnaSequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> cnt = new HashMap<String, Integer>();
        int n = s.length();
        for (int i = 0; i <= n - 10; ++i) {
            String sub = s.substring(i, i + 10);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2) {
                ans.add(sub);
            }
        }

        return ans;
    }

    public List<String> findRepeatedDnaSequences1(String s) {

        List<String> result = new ArrayList();
        List<String> lists = new ArrayList();
        int i = 0;
        int j = 10;

        while (i <= s.length() - 10 && j <= s.length()) {
            String t = s.substring(i, j);
            if (lists.contains(t) && !result.contains(t)) {
                result.add(t);
            } else {
                lists.add(t);
            }
            i++;
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        RepeatedDnaSequences repeatedDnaSequences = new RepeatedDnaSequences();
        String s = "AAAAAAAAAAA";
        List<String> result = repeatedDnaSequences.findRepeatedDnaSequences(s);
        System.out.println(result);
    }

}
