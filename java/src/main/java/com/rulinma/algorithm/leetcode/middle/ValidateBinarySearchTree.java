package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * @author 马如林
 * @Data 2022/7/5 11:51
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        if (root.left != null && root.left.val >= root.val) {
            return false;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        return (root.left != null && isValidBST(root.left)) && (root.right != null && isValidBST(root.right));

    }

}
