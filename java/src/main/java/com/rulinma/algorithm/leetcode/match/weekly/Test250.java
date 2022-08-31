package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 马如林
 * @Data 2022/8/31 11:14
 */
public class Test250 {

    /**
     * 1935. 可以输入的最大单词数
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        int rs = 0;

        List<String> words = new ArrayList<>();

        // 分隔单词
        int left = 0;
        for (int i = 0; i < text.length(); i++) {
            // 是空格
            if (text.charAt(i) == ' ') {
                // 分隔
                if (text.charAt(i - 1) != ' ') {
                    String x = text.substring(left, i);
                    words.add(x);
                }
            } else if (i - 1 >= 0 && text.charAt(i - 1) == ' ') {
                left = i;
            }
        }

        // 最后一个
        words.add(text.substring(left));

        for (String s : words) {
            boolean flag = true;
            for (char ch : brokenLetters.toCharArray()) {
                if (s.contains(String.valueOf(ch))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                rs++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
//        String text = "hello world";
//        String brokenLetters = "ad";

        String text = "leet code";
        String brokenLetters = "e";

        int rs = new Test250().canBeTypedWords(text, brokenLetters);
        System.out.println(rs);
    }

}
