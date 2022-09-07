package com.rulinma.algorithm.leetcode.other;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/1 07:54
 */
public class Test {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = x;
        int rs = 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
                rs = mid;
            } else if ((long) mid * mid > x) {
                right = mid - 1;
            }
        }

        // 最终

        return rs;
    }

    /**
     * 1475. 商品折扣后的最终价格
     */
    public int[] finalPrices(int[] prices) {
        int[] arr = new int[prices.length];
        // 每个位置寻找下一个比他值小的数
        // 使用单调栈获取每个位置的下一个小值的数
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                // 找到了当前栈内值的下一个满足条件值，下面存储该位置的值
                arr[stack.pop()] = prices[i];
            }
            // push下标
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            // 没有下一个小值的数
            arr[stack.pop()] = 0;
        }

        for (int i = 0; i < prices.length; i++) {
            arr[i] = prices[i] - arr[i];
        }

        return arr;
    }

    public int maxProfit(int[] prices) {
        int max = 0;
        int len = prices.length;
        int[] suffixMax = new int[len];

        int backMax = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            // 当前位置往后的最大值
            suffixMax[i] = backMax;
            if (prices[i] > backMax) {
                backMax = prices[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (suffixMax[i] - prices[i] > max) {
                max = suffixMax[i] - prices[i];
            }
        }

        return max;
    }

    /**
     * 1592. 重新排列单词间的空格
     */
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        // 1. 统计单词个数
        // 2. 统计空格个数
        // 3. sc/(wc-1) = n? sc%(wc-1)= m?

        char[] chars = text.toCharArray();
        int sc = 0;
        for (char ch : chars) {
            if (ch == ' ') {
                sc++;
            }
        }

        String[] sa = text.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : sa) {
            if (!"".equals(s)) {
                list.add(s);
            }
        }

        if (list.size() == 1) {
            sb.append(list.get(0).trim());
            for (int i = 0; i < sc; i++) {
                sb.append(' ');
            }
        } else {
            int esc = sc / (list.size() - 1);
            int remain = sc % (list.size() - 1);

            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).trim());
                if (i != list.size() - 1) {
                    for (int j = 0; j < esc; j++) {
                        sb.append(' ');
                    }
                } else {
                    for (int j = 0; j < remain; j++) {
                        sb.append(' ');
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

//        int[] prices = new int[]{7,1,5,3,6,4};
//
//        System.out.println(Arrays.toString(new Test().finalPrices(prices)));

//        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//
//        System.out.println(new Test().maxProfit(prices));

//        String text = "  this   is  a sentence ";
//        System.out.println(new Test().reorderSpaces(text));

//        System.out.println(new Test().mySqrt(4));
        System.out.println(new Test().mySqrt(8));
    }
}
