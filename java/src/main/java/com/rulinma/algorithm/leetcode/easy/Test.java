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

    public static void main(String[] args) {
        treeHeight();
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

}
