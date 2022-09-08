package com.rulinma.algorithm.leetcode.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 马如林
 * @Data 2022/9/8 08:40
 */
public class BeautifulArrangement {

    int rs = 0;

    int res = 0;
    int n;

    public int countArrangement(int n) {
        int[] nums = new int[n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        boolean[] visited = new boolean[n];
        dfs(nums, visited, new ArrayList<Integer>(), 1);
        return res;
    }

    public void dfs(int[] nums, boolean[] visited, List<Integer> temp, int level) {
        if (temp.size() == n) {
            res++;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            if (!(nums[i] % level == 0 || level % nums[i] == 0)) {
                continue;
            }
            visited[i] = true;
            temp.add(nums[i]);
            dfs(nums, visited, temp, level + 1);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 526. 优美的排列
     */
    public int countArrangement1(int n) {
//        return dfs(n, 1, new boolean[n + 1]);

        boolean[] visited = new boolean[n + 1];
        dfs1(n, 1, visited);

        return rs;
    }

    private void dfs1(int n, int v, boolean[] visited) {
        if (v > n) {
            rs++;
        }

        for (int num = 1; num <= n; num++) {
            if (!visited[num] && (num % v == 0 || v % num == 0)) {
                visited[num] = true;
                dfs1(n, v + 1, visited);
                visited[num] = false;
            }
        }
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
