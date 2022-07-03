package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ntree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 589. N 叉树的前序遍历
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 * <p>
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal
 *
 * @author 马如林
 * @Data 2022/7/3 19:44
 */
public class NAryTreePreorderTraversal {


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 递归
        traverse(root, list);

        return list;
    }

    public void traverse(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node ch : node.children) {
            traverse(ch, list);
        }
    }

    // 层次遍历
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 1 层次遍历
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // 考虑结束条件
        while (queue.size() > 0) {
            // 获取同一层数据，并在同一层进行处理
            int size = queue.size();
            while (size-- > 0) {
                Node node = queue.poll();
                list.add(node.val);
                List<Node> children = node.children;
                queue.addAll(children);
            }
        }

        return list;
    }

}
