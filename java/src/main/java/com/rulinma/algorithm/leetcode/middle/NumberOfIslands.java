package com.rulinma.algorithm.leetcode.middle;

/**
 * 200. 岛屿数量
 * <p>
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * https://leetcode.cn/problems/number-of-islands
 *
 * @author 马如林
 * @Data 2022/8/2 16:32
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;

        // 2种解题方法：
        // 1. dfs
        // 2. bfs

        // 解题步骤：
        // 1. 遍历所有节点
        // 2. 如果是陆地，则count+1，然后dfs该陆地（上下左右），扩展该陆地块，并且将陆地1则设置为水0（标记为已经访问过）
        // 3. 如果是水，则忽略，无需处理
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        // 边界条件处理
        // 四个方向同时进行处理
        int r = grid.length;
        int c = grid[0].length;
        // 越界
        if (i < 0 || j < 0 || i >= r || j >= c) {
            return;
        }
        // 碰到水域或已经访问过 grid[i][j] == '0' || grid[i][j] == '2'
//        if (grid[i][j] != '1') {
//            return;
//        }
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        // 标记已经访问过
        grid[i][j] = '2';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int rs = numberOfIslands.numIslands(grid);
        System.out.println(rs);

        char[][] grid1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int rs1 = numberOfIslands.numIslands(grid1);
        System.out.println(rs1);

    }
}
