package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 *
 * @author 马如林
 * @Data 2022/6/20 11:26
 */
public class PreorderTraversal {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        treaversal(root, list);

        return list;
    }

    public void treaversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        treaversal(node.left, list);
        treaversal(node.right, list);
    }

    // TODO: 迭代解法
}
