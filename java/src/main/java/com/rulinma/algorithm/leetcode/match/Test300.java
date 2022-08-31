package com.rulinma.algorithm.leetcode.match;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 马如林
 * @Data 2022/8/31 11:14
 */
public class Test300 {

    /**
     * 2325. 解密消息
     */
    public String decodeMessage(String key, String message) {
        StringBuilder sb = new StringBuilder();
        // 1 建立映射表
        // 2 替换message
        char[] ks = key.toCharArray();

        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();

        int i = 0;
        for (char ch : ks) {
            if (ch != ' ') {
                if (!set.contains(ch)) {
                    map.put(ch, (char) ('a' + i));
                    i++;
                    set.add(ch);
                }
            }
        }

        char[] msgs = message.toCharArray();
        for (char ch : msgs) {
            if (ch != ' ') {
                sb.append(map.get(ch));
            } else {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";

        String rs = new Test300().decodeMessage(key, message);
        System.out.println(rs);
    }

}
