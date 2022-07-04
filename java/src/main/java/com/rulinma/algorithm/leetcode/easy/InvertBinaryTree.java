package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree
 *
 * @author 马如林
 * @Data 2022/7/4 17:06
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        // 递归函数的终止条件，节点为空时返回
        if (root == null) {
            return null;
        }
        // 下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        // 递归交换当前节点的 左子树
        invertTree(root.left);
        // 递归交换当前节点的 右子树
        invertTree(root.right);
        // 函数返回时就表示当前这个节点，以及它的左右子树
        // 都已经交换完了
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            // 如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            // 如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.add(tmp.right);
            }

        }
        // 返回处理完的根节点
        return root;
    }

    public TreeNode invertTree0(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
