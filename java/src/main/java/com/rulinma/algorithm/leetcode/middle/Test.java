package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 马如林
 * @Data 2022/9/2 11:02
 */
public class Test {

    public int numIslands(char[][] grid) {
        int c = 0;
        // bfs
        // dfs
        // left up right down 四个方向dfs
        int row = grid.length;
        int col = grid[0].length;
        int[][] visited = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(grid, i, j, visited);
                    c++;
                }
            }
        }

        return c;
    }

    private void dfs(char[][] grid, int i, int j, int[][] visited) {
        // i j 判断
        // 上下左右处理的越界处理
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        // 访问过位置
        if (grid[i][j] == '1' && visited[i][j] == 0) {
            visited[i][j] = 1;
            dfs(grid, i - 1, j, visited);
            dfs(grid, i + 1, j, visited);
            dfs(grid, i, j - 1, visited);
            dfs(grid, i, j + 1, visited);
        }
    }


    int max = 0;

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    /**
     * 652. 寻找重复的子树
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs1(root);
        return ans;
    }

    String dfs1(TreeNode root) {
        if (root == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) {
            ans.add(root);
        }
        return key;
    }

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
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        Test test = new Test();
        System.out.println(test.numIslands(grid));
    }

}