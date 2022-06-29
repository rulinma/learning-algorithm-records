package com.rulinma.algorithm.leetcode.easy;

/**
 * 724. 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * <p>
 * https://leetcode.cn/problems/find-pivot-index
 *
 * @author 马如林
 * @Data 2022/6/29 10:04
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int total = 0;
        int ls = 0;
        for (int n : nums) {
            total += n;
        }

        for (int i = 0; i < nums.length; i++) {
            if (total - ls - nums[i] == ls) {
                return i;
            }
            ls += nums[i];
        }

        return -1;
    }

    public int pivotIndex0(int[] nums) {
        int pivot = 0;

        while (pivot < nums.length) {
            int ls = 0;
            int rs = 0;
            // 检查该pivot时的ls和rs
            for (int i = 0; i < pivot; i++) {
                ls += nums[i];
            }
            for (int j = pivot + 1; j < nums.length; j++) {
                rs += nums[j];
            }
            if (ls == rs) {
                return pivot;
            }

            pivot++;
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
//        int[] nums = new int[]{1, 2, 3};
//        int[] nums = new int[]{2, 1, -1};
        int result = findPivotIndex.pivotIndex(nums);
        System.out.println(result);
    }

}
