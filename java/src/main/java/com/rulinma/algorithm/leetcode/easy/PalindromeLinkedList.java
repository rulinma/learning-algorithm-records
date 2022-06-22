package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * <p>
 * https://leetcode.cn/problems/palindrome-linked-list/submissions/
 *
 * @author 马如林
 * @Data 2022/6/22 18:36
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 复制一份
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode old = head;
        while (old != null) {
            // new ListNode
            // 添加到当前链表
            ListNode node = new ListNode(old.val);
            current.next = node;
            current = current.next;
            old = old.next;
        }

        ListNode copy = dummy.next;

        ListNode tmp = reverseList(head);
        while (tmp != null) {
            if (tmp.val != copy.val) {
                return false;
            }
            copy = copy.next;
            tmp = tmp.next;
        }

        return true;
    }

    public ListNode reverseList(ListNode head) {
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

}
