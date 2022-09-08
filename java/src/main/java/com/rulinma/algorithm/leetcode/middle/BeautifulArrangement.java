package com.rulinma.algorithm.leetcode.middle;

/**
 * @author 马如林
 * @Data 2022/9/8 08:40
 */
public class BeautifulArrangement {

    /**
     * 526. 优美的排列
     */
    public int countArrangement(int n) {
        return dfs(n, 1, new boolean[n + 1]);
    }

    private int dfs(int n, int i, boolean[] visited) {
        if (i > n) {
            return 1;
        }

        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % i == 0 || i % num == 0)) {
                visited[num] = true;
                System.out.println("num: " + num);
                ans += dfs(n, i + 1, visited);
                System.out.println("ans: " + ans);
                visited[num] = false;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangementTwo = new BeautifulArrangement();

        int rs = beautifulArrangementTwo.countArrangement(3);

        System.out.println(rs);
    }
}
