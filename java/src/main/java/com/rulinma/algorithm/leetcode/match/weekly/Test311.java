package com.rulinma.algorithm.leetcode.match.weekly;

import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/9/18 10:30
 */
public class Test311 {

    /**
     * 6183. 字符串的前缀分数和
     */
    public int[] sumPrefixScores(String[] words) {

        String[] cp = Arrays.copyOfRange(words, 0, words.length);
        Arrays.sort(cp);

        int[] ans = new int[words.length];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            String[] rs = getPrefix(words[i]);
            for (String x : rs) {
                if (map.get(x) != null) {
                    sum += map.get(x);
                } else {
                    int v = getStrCount(x, cp);
                    map.put(x, v);
                    sum += v;
                }
            }

            ans[i] = sum;
        }

        return ans;
    }

    private int getStrCount(String x, String[] cp) {
        int c = 0;
        for (String s : cp) {
            if (s.startsWith(x) || s.equals(x)) {
                c++;
            }

            // cp: ab abc b bc
            // ab abc
//            if (x.compareTo(s) > 0) {
//                break;
//            }
//
//            if (s.compareTo(x) > 0) {
//                break;
//            }

        }

        return c;
    }

    public String[] getPrefix(String s) {
        String[] rs = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            rs[i] = s.substring(0, i + 1);
        }

        return rs;
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        // bfs
        Deque<TreeNode> deque = new LinkedList<>();
        // 遍历后重新构建
        List<TreeNode> list = new ArrayList<>();
        deque.add(root);
        int level = 0;
        while (!deque.isEmpty()) {
            int sz = deque.size();
            if (level % 2 != 0) {
                // 奇数
                Deque<TreeNode> tmp = new LinkedList<>();
                for (int i = 0; i < sz; i++) {
                    TreeNode t = deque.poll();
                    tmp.addFirst(t);
                    if (t != null) {
                        deque.add(t.left);
                        deque.add(t.right);
                    }
                }
                list.addAll(tmp);
            } else {
                for (int i = 0; i < sz; i++) {
                    TreeNode t = deque.poll();
                    list.add(t);
                    if (t != null) {
                        deque.add(t.left);
                        deque.add(t.right);
                    }
                }
            }
            level++;
        }

        // 根据list重新构建tree
        buildTree(list.get(0), 0, list);

        return root;
    }

    public TreeNode buildTree(TreeNode node, int index, List<TreeNode> list) {
        if (node == null) {
            return null;
        }

        if (index >= list.size()) {
            return null;
        }

        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < list.size()) {
            node.left = buildTree(list.get(left), left, list);
        } else {
            node.left = null;
        }
        if (right < list.size()) {
            node.right = buildTree(list.get(right), right, list);
        } else {
            node.right = null;
        }

        return node;
    }

    /**
     * 最长的字母序连续子字符串的长度
     */
    public int longestContinuousSubstring(String s) {
        // 动态规划
        // dp[i] 表示以i为结尾的字字符串长度
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 1; i < s.length(); i++) {
            // 如果i 是 i-1 的递增，则dp[i] = dp[i-1] + 1
            if (chars[i] - chars[i - 1] == 1) {
                dp[i] = dp[i - 1] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }

    /**
     * 6180. 最小偶倍数
     */
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        }

        return 2 * n;
    }

    public static void main(String[] args) {
        Test311 test311 = new Test311();
//        String s = "abacaba";
//        int rs = test311.longestContinuousSubstring(s);
//        System.out.println(rs);

//        TreeNode t1 = new TreeNode(7);
//        TreeNode t2 = new TreeNode(13);
//        TreeNode t3 = new TreeNode(11);
//
//        t1.left = t2;
//        t1.right = t3;
//
//        TreeNode root = test311.reverseOddLevels(t1);
//
//        System.out.println(root);

        String[] words = new String[]{"abc", "ab", "bc", "b"};
        int[] rs = test311.sumPrefixScores(words);
        System.out.println(Arrays.toString(rs));

    }
}
