package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 129. 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 9
 * 树的深度不超过 10
 * <p>
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers
 *
 * @author 马如林
 * @Data 2022/9/7 18:38
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        // 1. 遍历所有到叶子节点路径，目标和想等则返回true
        int sum = 0;
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        dfs(root, list, path);

        for (List<TreeNode> ls : list) {
            StringBuilder sb = new StringBuilder();
            for (TreeNode t : ls) {
                sb.append(t.val);
            }

            sum += Integer.parseInt(sb.toString());
        }

        return sum;
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
