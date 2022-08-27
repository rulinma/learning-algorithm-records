package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * 662. 二叉树最大宽度
 * 给你一棵二叉树的根节点 root ，返回树的 最大宽度 。
 * <p>
 * 树的 最大宽度 是所有层中最大的 宽度 。
 * <p>
 * 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 null 节点，这些 null 节点也计入长度。
 * <p>
 * 题目数据保证答案将会在  32 位 带符号整数范围内。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,3,null,9]
 * 输出：4
 * 解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5,null,null,9,6,null,7]
 * 输出：7
 * 解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,3,2,5]
 * 输出：2
 * 解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [1, 3000]
 * -100 <= Node.val <= 100
 * <p>
 * https://leetcode.cn/problems/maximum-width-of-binary-tree
 *
 * @author 马如林
 * @Data 2022/8/27 07:53
 */
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        int c = 0;

        // BFS
        // 统计每一层的宽度，这一层到末尾非null节点的长度
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty() && !isAllNull(deque)) {
            // 迭代
            List<TreeNode> list = new LinkedList<>();
            int sz = deque.size();

            //
            int len = getLen(deque);
            c = Math.max(c, len);

            for (int i = 0; i < sz; i++) {
                TreeNode t = deque.poll();
                if (t != null) {
                    list.add(t.left);
                    list.add(t.right);
                } else {
                    list.add(null);
                    list.add(null);
                }
            }
            deque.addAll(list);
        }

        return c;
    }

    public boolean isAllNull(Deque<TreeNode> deque) {
        for (TreeNode t : deque) {
            if (t != null) {
                return false;
            }
        }

        return true;
    }

    public int getLen(Deque<TreeNode> deque) {
        int l = 0;
        int sz = deque.size();

        // 第一个非空和最后一个非空
        Iterator<TreeNode> iterator = deque.iterator();
        List<TreeNode> list = new ArrayList<>();
        while (iterator.hasNext()) {
            TreeNode t = iterator.next();
            list.add(t);
        }

        // 从后往前计数，第一个非空的就是最终长度
        for (int i = sz - 1; i >= 0; i--) {
            if (list.get(i) == null) {
                l++;
            } else {
                break;
            }
        }

        int m = 0;
        for (int i = 0; i < sz; i++) {
            if (list.get(i) == null) {
                m++;
            } else {
                break;
            }
        }

        return sz - l - m;
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        TreeNode root5 = new TreeNode(5);

        root.left = root3;
        root.right = root2;
        root3.left = root5;

        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(root));
    }

}
