package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * <p>
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 * <p>
 * https://leetcode.cn/problems/4sum
 *
 * @author 马如林
 * @Data 2022/7/9 08:47
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        // 3个循环
        Arrays.sort(nums);
        // 进行剪枝处理
        // 1 nums[i] + nums[j] + nums[k]
        for (int i = 0; i < nums.length - 3; i++) {
            // 相同num[i]的进行消重

            if ((i - 1 > 0) && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int m = k + 1; m < nums.length; m++) {
                        if ((long) nums[i] + nums[j] + nums[k] + nums[m] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[m]);
                            if (!rs.contains(list)) {
                                rs.add(list);
                            }
                            break;
                        }
                        if ((long) nums[i] + nums[j] + nums[k] + nums[m] > target) {
                            break;
                        }
                    }
                }

            }

        }

        return rs;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
//        int[] nums = new int[]{2, 2, 2, 2, 2};
//        int target = 8;
        int[] nums = new int[]{-1000000000, -1000000000, 1000000000, -1000000000, -1000000000};
        int target = 294967296;
        List<List<Integer>> res = fourSum.fourSum(nums, target);
        System.out.println(res);
    }

}
