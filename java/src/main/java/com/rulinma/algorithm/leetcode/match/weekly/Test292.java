package com.rulinma.algorithm.leetcode.match.weekly;

import com.rulinma.algorithm.leetcode.common.TreeNode;

/**
 * @author 马如林
 * @Data 2022/9/26 09:25
 */
public class Test292 {

    int count = 0;

    /**
     * 2265. 统计值等于子树平均值的节点数
     */
    public int averageOfSubtree(TreeNode root) {
        dfs(root, 0);

        return count;
    }

    public int[] dfs(TreeNode node, Integer c) {
        if (node == null) {
            return new int[]{0, 0};
        }


        int[] left = dfs(node.left, c);
        int[] right = dfs(node.right, c);


        int sum = left[0] + right[0] + node.val;

        int nodes = left[1] + right[1] + 1;
        if (sum / nodes == node.val) {
            count++;
        }

        return new int[]{sum, nodes};
    }

    /**
     * 2264. 字符串中最大的 3 位相同数字
     */
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();

        StringBuilder sb = new StringBuilder();

        String max = "";
        int count = 1;
        sb.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                count = 1;
                sb = new StringBuilder();
                sb.append(chars[i]);
            } else {
                count++;
                sb.append(chars[i]);
                if (count == 3) {
                    if (max.compareTo(sb.toString()) < 0) {
                        max = sb.toString();
                    }
                    count = 1;
                    sb = new StringBuilder();
                    sb.append(chars[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
