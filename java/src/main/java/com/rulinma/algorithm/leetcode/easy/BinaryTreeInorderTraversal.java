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

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    // TODO: 迭代解法
}
