package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/6/23 12:28
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int i = 0;
        int ans = 0;
        while (i < s.length()) {
            if ((i + 2 <= s.length()) && map.get(s.substring(i, i + 2)) != null) {
                ans = ans + map.get(s.substring(i, i + 2));
                i = i + 2;
            } else {
                ans = ans + map.get(s.substring(i, i + 1));
                i++;
            }
        }

        return ans;
    }


}
