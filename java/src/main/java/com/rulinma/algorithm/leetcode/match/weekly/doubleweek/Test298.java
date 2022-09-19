package com.rulinma.algorithm.leetcode.match.weekly.doubleweek;

/**
 * @author 马如林
 * @Data 2022/9/19 17:24
 */
public class Test298 {

    public String greatestLetter(String s) {
        for (char ch = 'z'; ch >= 'a'; ch--) {
            if (s.contains(String.valueOf(ch)) && s.contains(String.valueOf(ch).toUpperCase())) {
                return String.valueOf(ch);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Test298 test298 = new Test298();
        System.out.println(test298.greatestLetter("lEeTcOdE"));
    }

}
