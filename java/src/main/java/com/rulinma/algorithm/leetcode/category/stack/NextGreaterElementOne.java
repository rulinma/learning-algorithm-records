package com.rulinma.algorithm.leetcode.category.stack;

import java.util.*;

/**
 * 496. 下一个更大元素 I
 * <p>
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出：[-1,3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
 * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出：[3,-1]
 * 解释：nums1 中每个值的下一个更大元素如下所述：
 * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
 * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length <= nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 104
 * nums1和nums2中所有整数 互不相同
 * nums1 中的所有整数同样出现在 nums2 中
 *  
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 * <p>
 * https://leetcode.cn/problems/next-greater-element-i
 *
 * @author 马如林
 * @Data 2022/9/1 09:25
 */
public class NextGreaterElementOne {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int[] rs = new int[nums2.length];
        Deque<Integer> deque = new LinkedList<>();
        // 1. nums2的单调栈获取每个位置的下一个更大值，不存在设置为-1
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[deque.peek()] < nums2[i]) {
                // 当前位置的下一个最大值是nums2[i]
                rs[deque.pop()] = nums2[i];
            }
            deque.push(i);
        }
        while (!deque.isEmpty()) {
            rs[deque.pop()] = -1;
        }

        // nums2的key和index map方便nums1查找
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = rs[map.get(nums1[i])];
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementOne nextGreaterElementOne = new NextGreaterElementOne();
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        int[] rs = new NextGreaterElementOne().nextGreaterElement(nums1, nums2);

        System.out.println(Arrays.toString(rs));
    }
}
