package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 链接：https://leetcode.cn/problems/3sum
 *
 * @author 马如林
 * @Data 2022/7/9 08:07
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        // 3个循环
        Arrays.sort(nums);
        // 进行剪枝处理
        // 1 nums[i] + nums[j] + nums[k]
        for (int i = 0; i < nums.length - 2; i++) {
            // 相同num[i]的进行消重
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        rs.add(list);
                        break;
                    }
                    if ((nums[i] + nums[j] + nums[k]) > 0) {
                        break;
                    }
                    // 后续相等，跳过处理
                    while ((k + 1 < nums.length) && nums[k] == nums[k + 1]) {
                        k++;
                    }
                }
                // 后续相等，跳过处理
                while ((j + 1 < nums.length - 1) && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            // 后续相等，跳过处理
            while ((i + 1 < nums.length - 2) && (nums[i] == nums[i + 1])) {
                i++;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum.threeSum(nums);
//        int[] nums = new int[]{-1, 0, 1};
//        List<List<Integer>> res = threeSum.threeSum(nums);
        System.out.println(res);
    }

}
