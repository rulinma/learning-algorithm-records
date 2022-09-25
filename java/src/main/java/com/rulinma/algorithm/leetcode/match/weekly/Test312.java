package com.rulinma.algorithm.leetcode.match.weekly;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/25 10:30
 */
public class Test312 {

    int rs = 0;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        // graph

        // 1. 开始==结束
        // 2. 中间节点小于开始和结束
        // bfs

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int e0 = e[0];
            int e1 = e[1];
            List<Integer> list1 = map.getOrDefault(e0, new ArrayList<>());
            list1.add(e1);
            map.put(e0, list1);

            List<Integer> list2 = map.getOrDefault(e1, new ArrayList<>());
            list2.add(e0);
            map.put(e1, list2);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            bfs(vals, edges, list, i, map);
        }


        return rs;
    }

    public void bfs(int[] vals, int[][] edges, List<Integer> list, Integer node, Map<Integer, List<Integer>> map) {
        if (list.isEmpty()) {
            rs++;
            list.add(node);
            return;
        } else if (!list.isEmpty() && list.get(list.size() - 1) <= node && list.get(0).equals(node)) {
            rs++;
            return;
        }

        // 选择边
        while (map.get(node) != null) {
            List<Integer> es = map.getOrDefault(node, new ArrayList<>());
            for (Integer i : es) {
                bfs(vals, edges, list, i, map);
            }
        }

        // 移除选择边
    }

    /**
     * 6190. 找到所有好下标
     */
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length - 1;
        // k <= i < n - k
        int maxI = n - k;
        if (k > maxI) {
            return ans;
        }
//        nums = [2,1,1,1,3,4,1], k = 2
        // i的k个之前非递增的和k个之后非递减的  2k+1 个元素
        // 获取每个元素的非递增个数
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        a[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                a[i] = a[i - 1] + 1;
            } else {
                a[i] = 1;
            }
        }

        b[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                b[i] = b[i - 1] + 1;
            } else {
                b[i] = 1;
            }
        }

        // k <= i < n - k 进行遍历
        for (int i = k; i <= maxI; i++) {
            // 判断
            if ((a[i - 1] >= k) && (b[i + k] - b[i + 1] == k - 1)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public int longestSubarray(int[] nums) {
        // 获取最大值
        // 获取最大值的个数（是否需要连续，题目未说明）
        // 从测试结果看需要连续的数字
        int ans = 0;

        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            max = Math.max(max, i);
        }

        // 等于最大值的连续个数
        int c = 0;
        for (int i : nums) {
            if (max == i) {
                c++;
                ans = Math.max(ans, c);
            } else {
                c = 0;
            }
        }

        return ans;
    }

    /**
     * 6188. 按身高排序
     */
    public String[] sortPeople(String[] names, int[] heights) {

        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        String[] rs = new String[names.length];

        Arrays.sort(heights);
        int j = 0;
        for (int i = heights.length; i >= 0; i--) {
            rs[j++] = map.get(heights[i]);
        }

        return rs;
    }


    public static void main(String[] args) {


    }
}
