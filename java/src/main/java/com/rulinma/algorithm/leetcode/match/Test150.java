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

    /**
     * 1160. 拼写单词
     */
    public int countCharacters(String[] words, String chars) {
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
