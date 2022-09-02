package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * @author 马如林
 * @Data 2022/9/2 11:02
 */
public class Test {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs((root));
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left);
            if (root.val == root.left.val) {
                left++;
            } else {
                left = 0;
            }
        }
        if (root.right != null) {
            right = dfs(root.right);
            if (root.val == root.right.val) {
                right++;
            } else {
                right = 0;
            }
        }

        max = Math.max(max, left + right);

        return Math.max(left, right);
    }


    public static void main(String[] args) {

    }
}
