package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * https://leetcode.cn/problems/two-sum-iv-input-is-a-bst
 *
 * @author 马如林
 * @Data 2022/7/7 13:59
 */
public class TwoSumIvInputIsABst {
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
