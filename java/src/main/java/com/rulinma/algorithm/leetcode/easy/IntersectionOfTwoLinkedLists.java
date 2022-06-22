package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 160. 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 *
 * @author 马如林
 * @Data 2022/6/22 14:31
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * pA:1->2->3->4->5->6->null->9->5->6->null
     * pB:9->5->6->null->1->2->3->4->5->6->null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1. A连接B B连接A 如果节点相等则是第一个相交节点，一个找不到就是null
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA != currentB) {
            // A的下一个节点
            if (currentA == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }

            // B的下一个节点
            if (currentB == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }

        return currentA;
    }

}
