package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * <p>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 * <p>
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 *
 * @author 马如林
 * @Data 2022/9/22 21:43
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int x : inorder) {
            map.put(x, i++);
        }

        return buildTree(preorder, 0, preorder.length - 1, map, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, Map<Integer, Integer> map, int iStart, int iEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[preStart]);

        int pivot = map.get(preorder[preStart]);

        treeNode.left = buildTree(preorder, preStart + 1, pivot - iStart + preStart, map, iStart, pivot - 1);
        treeNode.right = buildTree(preorder, pivot - iStart + preStart + 1, preEnd, map, pivot + 1, iEnd);

        return treeNode;
    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
//    }
//
//    public TreeNode buildNode(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
//        if (pStart == pEnd) {
//            return null;
//        }
//
//        TreeNode treeNode = new TreeNode(preorder[pStart]);
//        // 查找inorder
//        int num = 0;
//        for (int i = iStart; i < iEnd; i++) {
//            if (inorder[i] == preorder[pStart]) {
//                num = i;
//                break;
//            }
//        }
//        int leftNum = num - iStart;
//
//        treeNode.left = buildNode(preorder, pStart + 1, pStart + leftNum + 1, inorder, iStart, num);
//        treeNode.right = buildNode(preorder, pStart + leftNum + 1, pEnd, inorder, num + 1, iEnd);
//
//        return treeNode;
//    }


//
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
//    }
//
//    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
//        // preorder 为空，直接返回 null
//        if (p_start == p_end) {
//            return null;
//        }
//        int root_val = preorder[p_start];
//        TreeNode root = new TreeNode(root_val);
//        //在中序遍历中找到根节点的位置
//        int i_root_index = 0;
//        for (int i = i_start; i < i_end; i++) {
//            if (root_val == inorder[i]) {
//                i_root_index = i;
//                break;
//            }
//        }
//        int leftNum = i_root_index - i_start;
//        //递归的构造左子树
//        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
//        //递归的构造右子树
//        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
//        return root;
//    }

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        // 1.
//        TreeNode root = new TreeNode(preorder[0]);
//
//        // 2.
//        buildTree(root, preorder, inorder, 0, preorder.length);
//
//        return root;
//
//    }
//
//    public TreeNode buildTree(TreeNode node, int[] preorder, int[] inorder, int left, int right) {
//        if (left < 0 || right > 0) {
//            return null;
//        }
//
//        int value = node.val;
//        for (int i = left; i < right; i++) {
//            if (inorder[i] == value) {
//                node.left = buildTree(node, preorder, inorder, left, i - 1);
//                node.right = buildTree(node, preorder, inorder, i + 1, right);
//            }
//        }
//
//        return node;
//    }

    public static void main(String[] args) {

    }

}
