package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * @author 马如林
 * @Data 2022/6/22 18:06
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode node = getNthFromEnd(dummy, n + 1);
        node.next = node.next.next;

        return dummy.next;
    }

    public ListNode getNthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
