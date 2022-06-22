package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * @author 马如林
 * @Data 2022/6/21 22:40
 */
public class ReverseLinkedList {

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
