package com.rulinma.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *  
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 * <p>
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array
 *
 * @author 马如林
 * @Data 2022/6/26 16:07
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int count[] = new int[nums.length + 1];
        List<Integer> ans = new ArrayList<>();
        for (int a : nums) {
            count[a] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (count[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
