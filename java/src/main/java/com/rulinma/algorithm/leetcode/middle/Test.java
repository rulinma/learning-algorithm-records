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


    /**
     * 2133. 检查是否每一行每一列都包含全部整数
     */
    public boolean checkValid(int[][] matrix) {
        // 1. 获取每一行
        // 2. 遍历每一行，如果其值出现，则对应的数组位置设置为1，如果有非1的则该行数据不正确
        for (int[] x : matrix) {
            int[] arr = new int[matrix.length];
            for (int a : x) {
                arr[a - 1] = 1;
            }
            // check
            for (int i = 0; i < matrix.length; i++) {
                // 有一个没有被覆盖，就是错误
                if (arr[i] != 1) {
                    return false;
                }
            }
        }

        // 3. 遍历每一列
        for (int col = 0; col < matrix.length; col++) {
            int[] arr = new int[matrix.length];
            // 遍历每一行
            for (int row = 0; row < matrix.length; row++) {
                arr[matrix[row][col] - 1] = 1;
            }
            // check
            for (int i = 0; i < matrix.length; i++) {
                if (arr[i] != 1) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {

    }
}
