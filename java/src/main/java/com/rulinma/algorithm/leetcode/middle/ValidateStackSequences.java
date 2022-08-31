package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 946. 验证栈序列
 * <p>
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * pushed 的所有元素 互不相同
 * popped.length == pushed.length
 * popped 是 pushed 的一个排列
 * <p>
 * <p>
 * https://leetcode.cn/problems/validate-stack-sequences
 *
 * @author 马如林
 * @Data 2022/8/31 09:20
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 算法
//        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < pushed.length; i++) {
            // 1. 插入pushed
            // 2. 比较popped
            stack.push(pushed[i]);
            // 模拟出栈
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }

        return stack.isEmpty();
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        // 算法
        Deque<Integer> stack = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i : popped) {
            queue.add(i);
        }

        for (int i : pushed) {
            if (i != queue.peek()) {
                stack.push(i);
            } else {
                // 去除首
                queue.poll();
                // 后续可能也符合
                while (!stack.isEmpty()) {
                    // 继续pop
                    if (stack.peek().equals(queue.peek())) {
                        stack.pop();
                        queue.poll();
                    } else {
                        break;
                    }
                }
            }
        }

        // 比较剩下来的数据是否相等
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidateStackSequences validateStackSequences = new ValidateStackSequences();
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        boolean rs = validateStackSequences.validateStackSequences(pushed, popped);
        System.out.println(rs);
    }
}
