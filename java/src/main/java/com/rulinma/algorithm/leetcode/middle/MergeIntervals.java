package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * https://leetcode.cn/problems/merge-intervals
 *
 * @author 马如林
 * @Data 2022/6/29 16:56
 */
public class MergeIntervals {

    public int[][] merge(int[][] a) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(a, (x, y) -> x[0] - y[0]);
        int l = a[0][0], r = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > r) {
                res.add(new int[]{l, r});
                l = a[i][0];
                r = a[i][1];
            } else {
                r = Math.max(r, a[i][1]);
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {

    }
}
