package com.rulinma.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 2248. 多个数组求交集
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
 * 输出：[3,4]
 * 解释：
 * nums[0] = [3,1,2,4,5]，nums[1] = [1,2,3,4]，nums[2] = [3,4,5,6]，在 nums 中每个数组中都出现的数字是 3 和 4 ，所以返回 [3,4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1,2,3],[4,5,6]]
 * 输出：[]
 * 解释：
 * 不存在同时出现在 nums[0] 和 nums[1] 的整数，所以返回一个空列表 [] 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= sum(nums[i].length) <= 1000
 * 1 <= nums[i][j] <= 1000
 * nums[i] 中的所有值 互不相同
 * <p>
 * https://leetcode.cn/problems/intersection-of-multiple-arrays
 *
 * @author 马如林
 * @Data 2022/8/8 21:23
 */
public class IntersectionOfMultipleArrays {

    public List<Integer> intersection(int[][] nums) {
        List<Integer> rs = new ArrayList<>();

        int[] t = new int[1001];
        for (int[] x : nums) {
            for (int y : x) {
                t[y]++;
            }
        }

        int len = nums.length;

        int c = 0;
        for (int m : t) {
            if (m == len) {
                rs.add(c);
            }
            c++;
        }

        return rs;
    }

    public static void main(String[] args) {
//        nums = [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]]
        int[][] nums = new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};

        IntersectionOfMultipleArrays intersectionOfMultipleArrays = new IntersectionOfMultipleArrays();
        List<Integer> rs = intersectionOfMultipleArrays.intersection(nums);
        System.out.println(rs);
    }

}
