package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * https://leetcode.cn/problems/permutations
 *
 * @author 马如林
 * @Data 2022/7/8 16:44
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, path, ans);
        return ans;
    }

    public void dfs(int[] nums, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }

        for (int n : nums) {
            if (!path.contains(n)) {
                path.add(n);
                dfs(nums, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // nums = [1,2,3]
        // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        // backtrace
        List<Integer> path = new ArrayList<>();

        backtrace(nums, path, result);

        return result;
    }

    public void backtrace(int[] nums, List<Integer> path, List<List<Integer>> result) {
        // 退出条件
        if (path.size() == nums.length) {
            List<Integer> n = new ArrayList<>();
            n.addAll(path);
            result.add(n);
            return;
        }

        // 选择数据
        for (int num : nums) {
            if (path.contains(num)) {
                continue;
            }
            // 添加
            path.add(num);
            backtrace(nums, path, result);
            // 回退
            if (path.size() > 0) {
                path.remove(path.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations permutations = new Permutations();
        List<List<Integer>> rs = permutations.permute(nums);
        System.out.println(rs);
    }
}
