package com.rulinma.algorithm.leetcode.middle;

/**
 * 2352. 相等行列对
 * <p>
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 * <p>
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,2,1],[1,7,6],[2,7,7]]
 * 输出：1
 * 解释：存在一对相等行列对：
 * - (第 2 行，第 1 列)：[2,7,7]
 * <p>
 * https://leetcode.cn/problems/equal-row-and-column-pairs
 *
 * @author 马如林
 * @Data 2022/8/1 18:49
 */
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        // 行列进行遍历就可以
        // 数组下标进行控制
        int count = 0;
        int n = grid.length;
        // 行
        for (int i = 0; i < n; i++) {
            // 列
            for (int colx = 0; colx < n; colx++) {
                boolean flag = true;
                // 进行行列比较
                for (int j = 0, coly = 0; j < n; j++, coly++) {
                    // 每个行的数据
                    int x = grid[i][j];
                    // 列的数据
                    int y = grid[coly][colx];
                    if (x != y) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3, 2, 1}, {1, 7, 6}, {2, 7, 7}
        };

        EqualRowAndColumnPairs equalRowAndColumnPairs = new EqualRowAndColumnPairs();
        int rs = equalRowAndColumnPairs.equalPairs(grid);
        System.out.println(rs);
    }

}
