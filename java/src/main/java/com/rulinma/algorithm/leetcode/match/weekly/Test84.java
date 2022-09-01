package com.rulinma.algorithm.leetcode.match.weekly;

/**
 * @author 马如林
 * @Data 2022/9/1 15:32
 */
public class Test84 {

    /**
     * 832. 翻转图像
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        int[][] ans = new int[row][col];

        // 1. 复制每行从后向前
        for (int i = 0; i < row; i++) {
            // 获取里面的每一列
            for (int j = 0; j < col; j++) {
                // 反向复制
                ans[i][j] = image[i][col - j - 1];
                // 取反
                ans[i][j] = ans[i][j] == 1 ? 0 : 1;
            }
        }

        return ans;
    }


}
