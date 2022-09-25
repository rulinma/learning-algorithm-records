package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/9/25 18:18
 */
public class Test291 {

    /**
     * 2260. 必须拿起的最小连续卡牌数
     */
    public int minimumCardPickup(int[] cards) {
        int ans = 10000000;
        Map<Integer, Integer> map = new HashMap<>();
        int[] f = new int[cards.length];
        Arrays.fill(f, 10000000);

        for (int i = 0; i < cards.length; i++) {
            Integer index = map.get(cards[i]);
            if (index != null) {
                f[i] = i - index;
            }
            map.put(cards[i], i);
        }

        for (int i : f) {
            ans = Math.min(i, ans);
        }

        if (ans == 0) {
            return -1;
        }

        return ans + 1;
    }


    /**
     * 2259. 移除指定数字得到的最大结果
     */
    public String removeDigit(String number, char digit) {
        String max = "";
        // 暴力直接替换，寻找最大值
        char[] chars = number.toCharArray();

        // 去除其中的某个digit
        for (int i = 0; i < number.length(); i++) {
            if (chars[i] == digit) {
                // 替换的字符串
                String s = number.substring(0, i) + number.substring(i + 1, number.length());
                if (s.compareTo(max) > 0) {
                    max = s;
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        Test291 test291 = new Test291();
        int[] cards = new int[]{3, 4, 2, 3, 4, 7};
        int rs = test291.minimumCardPickup(cards);
        System.out.println(rs);
    }

}
