package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * https://leetcode.cn/problems/combinations
 *
 * @author 马如林
 * @Data 2022/7/4 11:28
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.combine(4, 2);
        System.out.println(result);
    }

}
