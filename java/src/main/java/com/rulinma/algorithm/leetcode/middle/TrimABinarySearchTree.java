package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * <p>
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是 唯一 的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 * <p>
 * <p>
 * https://leetcode.cn/problems/trim-a-binary-search-tree
 *
 * @author 马如林
 * @Data 2022/9/10 09:08
 */
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        // 1. 选择节点符合范围作为root
        // 2. 没有返回root
        // 3. 迭代左子树
        // 4. 迭代右子树
        while (root != null && !(root.val >= low && root.val <= high)) {
            if (root.val > high) {
                // 丢弃右子树，因为按照该树性质，右边的都比根节点值大，根已经大于high了，那其他的更大了。
                root = root.left;
            } else if (root.val < low) {
                // 丢弃左子树，都比根小，而根又比low小，所以丢弃。
                root = root.right;
            }
        }

        // 没有找到节点，或者此时root已经符合要求
        if (root == null) {
            return null;
        }

        // 迭代左子树
//        TreeNode parent = root;
//        TreeNode left = parent.left;
//        while (left != null) {
//            // 寻找下一个迭代
//            if (left.val < low) {
//                parent.left = parent.left.right;
//            } else {
//                parent = parent.left;
//            }
//            left = parent.left;
//        }

//        for (TreeNode node = root; node.left != null; ) {
//            if (node.left.val < low) {
//                node.left = node.left.right;
//            } else {
//                node = node.left;
//            }
//        }

        TreeNode node = root;
        while (node.left != null) {
            if (node.left.val < low) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }

        // 迭代右子树
        TreeNode parent2 = root;
        TreeNode right = root.right;
        while (right != null) {
            // 寻找下一个迭代
            if (right.val > high) {
                parent2.right = parent2.right.left;
            } else {
                parent2 = parent2.right;
            }
            right = parent2.right;
        }

        return root;
    }

    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST2(root.right, low, high);
        } else if (root.val > high) {
            return trimBST2(root.left, low, high);
        } else {
            TreeNode left = trimBST2(root.left, low, high);
            TreeNode right = trimBST2(root.right, low, high);
            root.left = left;
            root.right = right;
            return root;
        }
    }

    private TreeNode trim(TreeNode root, int low, int high) {
        // 一个节点为例
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trim(root.right, low, high);
        } else if (root.val > high) {
            return trim(root.left, low, high);
        } else {
            TreeNode left = trim(root.left, low, high);
            TreeNode right = trim(root.right, low, high);
            root.left = left;
            root.right = right;
            return root;
        }
    }

    public static void main(String[] args) {

    }
}
