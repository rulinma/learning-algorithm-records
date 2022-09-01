package com.rulinma.algorithm.leetcode.category.stack;

import java.util.*;

/**
 * 503. 下一个更大元素 II
 * <p>
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * https://leetcode.cn/problems/next-greater-element-ii
 *
 * @author 马如林
 * @Data 2022/9/1 09:25
 */
public class NextGreaterElementTwo {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len];
        Arrays.fill(arr, -1);
        // 统计单调栈
        // 可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），我们就把这些元素保存，直到找到一个较大的元素；
        // 把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」。
        Deque<Integer> deque = new LinkedList<>();
        // 1. arr的单调栈获取每个位置的下一个更大值，不存在设置为-1
        for (int i = 0; i < len * 2; i++) {
            while (!deque.isEmpty() && nums[deque.peek()] < nums[i % len]) {
                // 当前位置的下一个最大值是arr[i]
                arr[deque.pop()] = nums[i % len];
            }
            deque.push(i % len);
        }

        return arr;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int[] rs = new int[nums.length * 2];

        // 数组扩张1倍计算
        int[] arr = new int[nums.length * 2];
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[i + len] = nums[i];
        }

        // 统计单调栈
        // 可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），我们就把这些元素保存，直到找到一个较大的元素；
        // 把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」。
        Deque<Integer> deque = new LinkedList<>();
        // 1. arr的单调栈获取每个位置的下一个更大值，不存在设置为-1
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[deque.peek()] < arr[i]) {
                // 当前位置的下一个最大值是arr[i]
                rs[deque.pop()] = arr[i];
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            rs[deque.pop()] = -1;
        }

        int[] ans = new int[nums.length];

        System.arraycopy(rs, 0, ans, 0, len);
        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementTwo nextGreaterElementOne = new NextGreaterElementTwo();
        int[] nums1 = new int[]{1, 2, 1};
        int[] nums2 = new int[]{1, 2, 3, 4, 3};

        int[] rs = new NextGreaterElementTwo().nextGreaterElements(nums1);
        System.out.println(Arrays.toString(rs));

        int[] rs2 = new NextGreaterElementTwo().nextGreaterElements(nums2);
        System.out.println(Arrays.toString(rs2));
    }
}
