package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * @author 马如林
 * @Data 2022/6/22 17:38
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        // 1 slow 2 fast
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                // 已经到末尾
                return slow;
            }
            slow = slow.next;
        }

        return slow;
    }


}
