package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst
 *
 * @author 马如林
 * @Data 2022/7/10 16:43
 */
public class MinimumAbsoluteDifferenceInBst {

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        int minRes = Integer.MAX_VALUE;
        inOrder(root, res);
        // 求最小绝对差
        for (int i = 0; i < res.size() - 1; i++) {
            minRes = Math.min(res.get(i + 1) - res.get(i), minRes);
        }
        return minRes;
    }

}
