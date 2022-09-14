package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal
 *
 * @author 马如林
 * @Data 2022/9/14 11:32
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        if (root == null) {
            return rs;
        }

        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = deque.poll();
                if (level % 2 == 0) {
                    levelList.offerLast(node.val);
                } else {
                    levelList.offerFirst(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            rs.add(new LinkedList<Integer>(levelList));
            level++;
        }

        return rs;
    }

    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
//        TreeNode t6 = new TreeNode(3);
//        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        t3.left = t4;
        t3.right = t5;

        BinaryTreeZigzagLevelOrderTraversal binaryTreeZigzagLevelOrderTraversal = new BinaryTreeZigzagLevelOrderTraversal();
        System.out.println(binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(t1));

    }
}
