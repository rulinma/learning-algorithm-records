package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
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
