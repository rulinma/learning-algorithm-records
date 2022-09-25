package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/9/25 10:30
 */
public class Test312 {

    /**
     * 6188. 按身高排序
     */
    public String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        String[] rs = new String[names.length];

        Arrays.sort(heights);
        int j = 0;
        for (int i = heights.length; i >= 0; i--) {
            rs[j++] = map.get(heights[i]);
        }

        return rs;
    }

}
