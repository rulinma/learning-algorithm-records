package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree
 *
 * @author 马如林
 * @Data 2022/7/10 11:30
 */
public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {

        // 二叉树的众数
        // 1. 遍历二叉树，添加节点值，如果存在+1，最后遍历集合，最高的返回。
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        List<Integer> list = new ArrayList<>();

        Collection<Integer> values = map.values();
        int max = Integer.MIN_VALUE;
        for (Integer x : values) {
            if (x > max) {
                max = x;
            }
        }

        // 添加所有value==max的key，并去重即可。
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                if (!list.contains(entry.getKey())) {
                    list.add(entry.getKey());
                }
            }
        }

        int[] rs = new int[list.size()];
        int i = 0;
        for (Integer n : list) {
            rs[i++] = n;
        }
        return rs;
    }

    private void traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        Integer i = map.get(root.val);
        if (i == null) {
            map.put(root.val, 1);
        } else {
            map.put(root.val, 1 + i);
        }

        traverse(root.left, map);
        traverse(root.right, map);
    }


    public static void main(String[] args) {
        // root = [1,null,2,2]
        // [2]
    }
}
