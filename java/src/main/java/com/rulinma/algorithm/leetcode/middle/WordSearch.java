package com.rulinma.algorithm.leetcode.middle;

/**
 * 79. 单词搜索
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 *  
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 *
 * https://leetcode.cn/problems/word-search
 *
 * @author 马如林
 * @Data 2022/9/22 21:10
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        // dfs
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int len, int i, int j, boolean[][] visited) {
        if (len >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (board[i][j] != word.charAt(len)) {
            return false;
        }

        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;

        if (visited[i][j] == false) {
            visited[i][j] = true;
            // System.out.println("i " + i + " j " + j + " len " + len);
            // 向上下左右
            b1 = dfs(board, word, len + 1, i, j - 1, visited);
            b2 = dfs(board, word, len + 1, i, j + 1, visited);
            b3 = dfs(board, word, len + 1, i - 1, j, visited);
            b4 = dfs(board, word, len + 1, i + 1, j, visited);
            visited[i][j] = false;
        }

        return b1 || b2 || b3 || b4;
    }

    public static void main(String[] args) {

    }
}
