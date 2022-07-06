package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * <p>
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree
 *
 * @author 马如林
 * @Data 2022/7/6 17:14
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            // root == null 为终止条件，此时新建结点，并返回插入
            return new TreeNode(val);
        }
        if (root.val < val) {
            // val 比root值大，对右子树结点进行递归操作
            root.right = insertIntoBST(root.right, val);
        } else {
            // val 比root值小，对左子树结点进行递归操作
            root.left = insertIntoBST(root.left, val);
        }
        // 向上层返回已经完成插入操作的结点
        return root;
    }
}
