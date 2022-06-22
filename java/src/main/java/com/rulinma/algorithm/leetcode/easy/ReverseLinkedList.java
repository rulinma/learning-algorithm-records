package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author 马如林
 * @Data 2022/6/21 22:40
 */
public class ReverseLinkedList {

    /**
     * 递归实现
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // TODO:

        return head;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        // cur pre 结构
        while (pre != null) {
            // 下面顺便一个不能错！
            // 保存下一个节点
            ListNode next = pre.next;
            // 反向指向
            pre.next = cur;
            // 后移cur
            cur = pre;
            // 后移pre
            pre = next;
        }

        return cur;
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        // 1.  pre current next 指针转换
        while (cur != null) {
            // 保存下一个节点
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
