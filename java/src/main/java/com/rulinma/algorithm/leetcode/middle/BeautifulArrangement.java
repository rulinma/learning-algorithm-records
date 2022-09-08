package com.rulinma.algorithm.leetcode.middle;

import java.util.Arrays;

/**
 * @author 马如林
 * @Data 2022/9/8 08:40
 */
public class BeautifulArrangement {

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
                ans += dfs(n, i + 1, visited);
                visited[num] = false;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangementTwo = new BeautifulArrangement();

        int rs = beautifulArrangementTwo.countArrangement(2);

        System.out.println(rs);
    }
}
