package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * https://leetcode.cn/problems/path-sum
 *
 * @author 马如林
 * @Data 2022/7/5 09:08
 */
public class PathSum {

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // 1. 遍历所有到叶子节点路径，目标和想等则返回true
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        dfs(root, list, path);

        for (List<TreeNode> ls : list) {
            int sum = 0;
            for (TreeNode t : ls) {
                sum += t.val;
            }
            if (sum == targetSum) {
                return true;
            }
        }

        return false;
    }

    public void dfs(TreeNode treeNode, List<List<TreeNode>> list, List<TreeNode> path) {
        // 叶子节点
        if (treeNode.left == null && treeNode.right == null) {
            List<TreeNode> old = new ArrayList<>();
            for (TreeNode t : path) {
                old.add(t);
            }
            old.add(treeNode);
            list.add(old);
            return;
        }

        path.add(treeNode);
        List<TreeNode> old1 = new ArrayList<>();
        for (TreeNode t : path) {
            old1.add(t);
        }

        List<TreeNode> old2 = new ArrayList<>();
        for (TreeNode t : path) {
            old2.add(t);
        }
        if (treeNode.left != null) {
            dfs(treeNode.left, list, old1);
        }
        if (treeNode.right != null) {
            dfs(treeNode.right, list, old2);
        }
    }

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // bfs
        // dfs
        return has(root, 0, targetSum);
    }

    public boolean has(TreeNode node, int pathSum, int target) {
        // 为空离开退出
        if (node == null) {
            return false;
        }

        // 叶子节点
        if (node.left == null && node.right == null) {
            return pathSum + node.val == target;
        }

        return has(node.left, pathSum + node.val, target) || has(node.right, pathSum + node.val, target);

    }


}
