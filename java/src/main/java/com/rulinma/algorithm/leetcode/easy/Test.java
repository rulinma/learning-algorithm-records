package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;
import com.rulinma.algorithm.leetcode.common.TreeNode;

import java.util.*;

/**
 * @author 马如林
 * @Data 2022/8/4 12:26
 */
public class Test {

    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        // 去重
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        set.add(1L);
        heap.offer(1L);

        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }

        return ugly;
    }

    public int maxSubArray(int[] nums) {
        // 1 算出dp[i]的最大值
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // 前面子串的子数组最大和的值>0，累加才有可能变大
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        for (int x : dp) {
            if (x > max) {
                max = x;
            }
        }

        return max;
    }

    public int singleNumber(int[] nums) {
        int rs = -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int s = map.getOrDefault(n, 0);
            if (s > 0) {
                map.put(n, s + 1);
            } else {
                map.put(n, 1);
            }
        }

        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        return rs;
    }

    public static ListNode reverseNode(ListNode listNode) {
        ListNode pre = null;
        ListNode head = listNode;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private static void merge2List() {
        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        l2.next = l21;

        ListNode listNode = mergeOrderListNode(l1, l2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeOrderListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }

        while (l1 != null) {
            head.next = l1;
            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null) {
            head.next = l2;
            l2 = l2.next;
            head = head.next;
        }

        return dummy.next;
    }

    private static void revertedListNode() {
        // 链表反转

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(5);
        ListNode l13 = new ListNode(15);
        l1.next = l11;
        l11.next = l12;
        l12.next = l13;

        ListNode x = l1;
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

        // reverse list
        System.out.println("-----");

//        merge2List();
        ListNode listNode = reverseNode(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    private static void treeHeight() {
        // Tree的深度和遍历
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode left_l = new TreeNode(4);
        TreeNode left_r = new TreeNode(5);

        root.left = left;
        root.right = right;

        left.left = left_l;
        left.right = left_r;

        int rs = treeHeight(root);

        System.out.println(rs);
    }

    public static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }

    public static int treeHeight2(TreeNode root) {
        int rs = 0;

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            // 添加左右孩子
            List tmp = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                TreeNode node = list.poll();
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            list.addAll(tmp);

            rs++;
        }

        return rs;
    }

    private static void bfsTreeHeight() {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);

        TreeNode left_l = new TreeNode(4);
        TreeNode left_r = new TreeNode(5);

        root.left = left;
        root.right = right;

        left.left = left_l;
        left.right = left_r;

        int rs = treeHeight2(root);
        System.out.println(rs);
    }

    private int climbStairs(int n) {
        int[] s = new int[n + 1];

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        s[1] = 1;
        s[2] = 2;

        int k = 3;
        while (k <= n) {
            s[k] = s[k - 1] + s[k - 2];
            k++;
        }

        return s[n];
    }

    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        // amout是金额
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            // j 金币的价值
            for (int v : coins) {
                if ((i - v >= 0) && (memo[i - v] < min)) {
                    min = memo[i - v] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }


    private static void arrTest() {
        //        String s = "011101";
//        String s = "00111";
//        arrTest();
        String s = "1111";

        char[] chars = s.toCharArray();

        int first = 0;
        int left = 0;
        int leftOne = 0;
        int last = 0;

        first = chars[0] == '0' ? 1 : 0;
        last = chars[s.length() - 1] == '1' ? 1 : 0;
        int totalOne = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if (chars[i] == '1') {
                totalOne++;
            }
        }

        int max = totalOne;

        for (int i = 1; i < s.length() - 1; i++) {
            // i 时的0的个数
            if (chars[i] == '0') {
                left++;
            } else {
                leftOne++;
                // i 时的右边1的个数
            }
            max = Math.max(left + totalOne - leftOne, max);
        }


        int result = first + max + last;
        System.out.println(result);

        // 回溯和递归
        // abc字符的全排列
//        List<String> rs = new ArrayList<>();
//        List<Character> list = new ArrayList<>();
//        backtrace(list, rs, "abc".toCharArray());
//
//        for (String s : rs) {
//            System.out.println(s);
//        }

//        List<List<Integer>> rs = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        int[] nums = new int[]{1, 2, 3};
//        backtrace1(list, rs, nums);
//
//        for (List<Integer> s : rs) {
//            System.out.println(s);
//        }
    }

    public static void backtrace(List<Character> list, List<String> rs, char[] s) {
        if (list.size() == s.length) {
            StringBuilder sb = new StringBuilder();
            for (Character character : list) {
                sb.append(character);
            }
            rs.add(sb.toString());
            return;
        }

        for (char ch : s) {
            if (!list.contains(ch)) {
                list.add(ch);
                backtrace(list, rs, s);
                list.remove(list.size() - 1);
            } else {
                //
            }
        }

    }

    public static void backtrace1(List<Integer> list, List<List<Integer>> rs, int[] arr) {
        if (list.size() == arr.length) {
            List<Integer> newList = new ArrayList<Integer>(list);
            rs.add(newList);
            return;
        }

        for (int ch : arr) {
            if (!list.contains(ch)) {
                list.add(ch);
                backtrace1(list, rs, arr);
                list.remove(list.size() - 1);
            } else {
                //
            }
        }

    }

    public int minimumRecolors(String blocks, int k) {
        // K区间范围的个数-B的个数就是就是需要翻转的个数，取最小值
        int min = k;

        char[] chars = blocks.toCharArray();

        int blackCount = 0;
        int left = 0;

        for (int i = 0; i < chars.length; i++) {
            // k个区间取值

            if (chars[i] == 'B') {
                blackCount++;
            }

            // K个长度了，进行判定
            if (i - left == k - 1) {
                min = Math.min(k - blackCount, min);
                // 左指针移动
                if (chars[left] == 'B') {
                    blackCount--;
                }
                left++;
            }
        }

        return min;
    }


    public static void main(String[] args) {
        Test test = new Test();
        int rs = test.minimumRecolors("WBWBBBW", 2);
        System.out.println(rs);
    }

}
