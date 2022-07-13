package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * https://leetcode.cn/problems/daily-temperatures
 *
 * @author 马如林
 * @Data 2022/7/13 09:17
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        // 栈的后进先出的道理，使用单调递减栈
        int[] rs = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                rs[index] = i - index;
            }
            stack.push(i);
        }

        return rs;
    }


    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        // 单调递减栈，一旦大于，则可以出栈并计算值，直到栈是递减的
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            // 比较下标对应的值
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            // 栈存储的是index
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] t = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] rs = dailyTemperatures.dailyTemperatures(t);
        System.out.println(Arrays.toString(rs));
    }
}
