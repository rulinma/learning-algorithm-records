package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;
import javafx.util.Pair;

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

    public int widthOfBinaryTree1(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode, Integer>> arr = new ArrayList<Pair<TreeNode, Integer>>();
        arr.add(new Pair<TreeNode, Integer>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<Pair<TreeNode, Integer>>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }

    /**
     * 暴力解法
     */
    public int widthOfBinaryTree(TreeNode root) {
        int c = 0;

        int index = 0;

        // BFS
        // 统计每一层的宽度，这一层到末尾非null节点的长度
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<Integer> indexDeque = new LinkedList<>();
        deque.add(root);
        indexDeque.add(0);
        while (!deque.isEmpty()) {
            // 迭代
            List<TreeNode> list = new LinkedList<>();
            List<Integer> indexList = new LinkedList<>();
            int sz = deque.size();

            int leftIndex = index;
            int rightIndex = index;

            for (int i = 0; i < sz; i++) {
                TreeNode t = deque.poll();
                // 当前节点对应的pos
                Integer pos = indexDeque.poll();
                if (t.left != null) {
                    list.add(t.left);
                    indexDeque.add(pos * 2 + 1);
                }
                if (t.right != null) {
                    list.add(t.right);
                    indexDeque.add(pos * 2 + 2);
                }

                if (i == 0) {
                    leftIndex = pos;
                }
                if (i == sz - 1) {
                    rightIndex = pos;
                }
            }

            int len = rightIndex - leftIndex + 1;
            System.out.println(len);

            c = Math.max(c, len);

            deque.addAll(list);
            indexDeque.addAll(indexList);
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
//        TreeNode root = new TreeNode(1);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root2 = new TreeNode(2);
//        TreeNode root5 = new TreeNode(5);
//
//        root.left = root3;
//        root.right = root2;
//        root3.left = root5;
//
//        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(root));
//
//        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(new TreeNode(1)));


        TreeNode root = new TreeNode(0);
        TreeNode root3 = new TreeNode(0);
        TreeNode root2 = new TreeNode(0);
//        TreeNode root5 = new TreeNode(0);

        root.left = root3;
        root.right = root2;

        System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(root));
    }

}
