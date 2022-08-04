package com.rulinma.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 马如林
 * @Data 2022/8/4 12:26
 */
public class Test {

    public int singleNumber(int[] nums) {
        int rs = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int s = map.getOrDefault(n, 0);
            if (s > 0) {
                map.put(n, s + 1);
            } else {
                map.put(n, 1);
            }
        }

        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return rs;
    }

}
