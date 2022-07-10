package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * https://leetcode.cn/problems/binary-tree-paths/
 *
 * @author 马如林
 * @Data 2022/7/10 08:43
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        traverse(root, "", result);
        return result;
    }

    public void traverse(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }
        StringBuffer newPath = new StringBuffer(path);
        newPath.append(Integer.toString(node.val));
        // 叶子节点
        if (node.left == null && node.right == null) {
            result.add(newPath.toString());
        } else {
            newPath.append("->");
            traverse(node.left, newPath.toString(), result);
            traverse(node.right, newPath.toString(), result);
        }
    }

    public static void main(String[] args) {
        // 1,2,3,null,5
        test1();

//        [1,2,3,null,null,4]

//        TreeNode treeNode = new TreeNode(1);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(4);
//
//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//
//        treeNode2.left = treeNode3;
//
//        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
//        List<String> rs = binaryTreePaths.binaryTreePaths(treeNode);
//        System.out.println(rs);

    }

    private static void test1() {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(5);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.right = treeNode3;

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> rs = binaryTreePaths.binaryTreePaths(treeNode);
        System.out.println(rs);
    }

}
