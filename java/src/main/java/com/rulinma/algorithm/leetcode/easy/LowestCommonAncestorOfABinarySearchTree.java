package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * 235. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree
 *
 * @author 马如林
 * @Data 2022/7/5 11:42
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 2个节点的父节点相同，或者其中1个是父节点
        // p节点的父节点列表 q节点的父节点列表 查看最后交叉的地方就是最近公共祖先（反转后第一个交叉的地方）
        Map<Integer, Integer> map = new HashMap<>();

        dfs(root, map, null);

        int anc = -1;
        // 获取parent列表
        List<Integer> p1 = getParent(p, map);
        List<Integer> p2 = getParent(q, map);

        Set<Integer> set = new HashSet<>();
        for (Integer x : p1) {
            set.add(x);
            //System.out.println("x1: " + x);
        }

        // for (Integer x : p2) {
        //     //System.out.println("x2: " + x);
        // }
        for (int i = 0; i < p2.size(); i++) {
            //System.out.println("x3: " + p2.get(i));
            if (set.contains(p2.get(i))) {
                // 最近公共祖先
                anc = p2.get(i);
                break;
            }
        }

        // 根据val查找到TreeNode
        // System.out.println("anc: " + anc);
        TreeNode rs = dfs(root, anc);

        return rs;
    }

    private TreeNode dfs(TreeNode root, int v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                // System.out.println("t: " + t.val);
                if (t.val == v) {
                    return t;
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
        }

        return null;
    }

    private List<Integer> getParent(TreeNode p, Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList<>();
        Integer v = p.val;

        while (v != null) {
            list.add(v);
            v = map.get(v);
        }

        return list;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            map.put(root.val, parent.val);
        }
        dfs(root.left, map, root);
        dfs(root.right, map, root);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 如果小于0，说明p和q位于root的两侧，直接返回即可
        // 等于0，则当前root就是公共祖先
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }
        // 否则，p和q位于root的同一侧，就继续往下找
        return lowestCommonAncestor1(p.val < root.val ? root.left : root.right, p, q);
    }
}
