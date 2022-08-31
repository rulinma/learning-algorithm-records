package com.rulinma.algorithm.leetcode.match;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/8/31 11:14
 */
public class Test150 {

    public int countCharacters(String[] words, String chars) {
        int[] chars_count = count(chars); // 统计字母表的字母出现次数
        int res = 0;
        for (String word : words) {
            int[] word_count = count(word); // 统计单词的字母出现次数
            if (contains(chars_count, word_count)) {
                res += word.length();
            }
        }
        return res;
    }

    // 检查字母表的字母出现次数是否覆盖单词的字母出现次数
    boolean contains(int[] chars_count, int[] word_count) {
        for (int i = 0; i < 26; i++) {
            if (chars_count[i] < word_count[i]) {
                return false;
            }
        }
        return true;
    }

    // 统计 26 个字母出现的次数
    int[] count(String word) {
        int[] counter = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            counter[c - 'a']++;
        }
        return counter;
    }

    /**
     * 1160. 拼写单词
     */
    public int countCharacters1(String[] words, String chars) {
        int rs = 0;
        Map<Character, Integer> map = CharCount(chars);
        // 检查每个word能否用chars表示出来
        for (String word : words) {
            if (word.length() > chars.length()) {
                continue;
            }

            // 检查字符串是否可以表示
            // 统计word中每个单词出现的次数，如果这些单词<=在map中的次数，则添加该单词长度
            boolean contain = true;
            Map<Character, Integer> tmp = CharCount(word);
            // 迭代tmp
            Iterator<Character> iterator = tmp.keySet().iterator();
            while (iterator.hasNext()) {
                char c = iterator.next();
                if (tmp.get(c) > map.getOrDefault(c, 0)) {
                    contain = false;
                    break;
                }
            }

            if (contain) {
                rs += word.length();
            }
        }

        return rs;
    }

    private Map<Character, Integer> CharCount(String chars) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars1 = chars.toCharArray();
        for (char ch : chars1) {
            int c = map.getOrDefault(ch, 0);
            map.put(ch, c + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";

        int rs = new Test150().countCharacters(words, chars);
        System.out.println(rs);
    }

}
