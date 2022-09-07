package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * <p>
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * <p>
 * https://leetcode.cn/problems/path-sum-ii
 *
 * @author 马如林
 * @Data 2022/9/7 18:44
 */
public class PathSumTwo {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 1. 遍历所有到叶子节点路径，目标和想等则返回true
        List<List<TreeNode>> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();

        if (root == null) {
            return result;
        }

        dfs(root, list, path);

        for (List<TreeNode> ls : list) {
            int tmp = 0;
            List<Integer> x = new ArrayList<>();
            for (TreeNode t : ls) {
                tmp += t.val;
                x.add(t.val);
            }

            if (targetSum == tmp) {
                result.add(x);
            }
        }

        return result;
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

}
