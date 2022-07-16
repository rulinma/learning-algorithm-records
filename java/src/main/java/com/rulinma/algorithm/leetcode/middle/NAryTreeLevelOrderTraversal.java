package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.ntree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal
 *
 * @author 马如林
 * @Data 2022/7/16 09:09
 */
public class NAryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> rs = new ArrayList<List<Integer>>();

        if(root==null) {
            return rs;
        }

        // 层次遍历
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while (!q.isEmpty()) {
            int cnt = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                Node cur = q.poll();
                level.add(cur.val);
                for (Node node : cur.children) {
                    q.add(node);
                }
            }
            rs.add(level);
        }

        return rs;
    }

}
