package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @author 马如林
 * @Data 2022/6/19 18:44
 */
public class BinaryTreeInorderTraversal {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderTraversal(root);
        return list;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
