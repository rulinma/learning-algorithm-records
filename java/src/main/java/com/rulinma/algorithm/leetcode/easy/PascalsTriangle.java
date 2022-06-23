package com.rulinma.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * https://leetcode.cn/problems/pascals-triangle/
 *
 * @author 马如林
 * @Data 2022/6/23 19:53
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> pre = new ArrayList<>();
        if (numRows >= 1) {
            pre.add(1);
            result.add(pre);
        }

        int i = 1;
        while (i < numRows) {
            List<Integer> list = new ArrayList<>();
            int preLen = pre.size();
            // 添加第一个
            list.add(pre.get(0));
            // 中间
            for (int j = 0; j < preLen - 1; j++) {
                int v = pre.get(j) + pre.get(j + 1);
                list.add(v);
            }
            // 添加最后一个
            list.add(pre.get(pre.size() - 1));
            result.add(list);

            pre = list;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }
}
