package com.rulinma.algorithm.leetcode.other;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author 马如林
 * @Data 2022/9/1 07:54
 */
public class Test {

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

    public static void main(String[] args) {

        int[] prices = new int[]{8, 4, 6, 2, 3};

        System.out.println(Arrays.toString(new Test().finalPrices(prices)));

    }
}
