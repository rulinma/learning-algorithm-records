package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 *
 * @author 马如林
 * @Data 2022/6/20 10:44
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        // 1. 开始条件、结束条件
        // 2. 处理

        ListNode cur = head;
        while (cur != null) {
            // cur 和 cur 下一个相同，则移除cur.next(cur.next=cur.next.next)
            if (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else if (cur.next == null) {
                // 末尾
                break;
            } else if (cur.next != null && cur.val != cur.next.val) {
                // 不相等，cur则后移
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        // 1. 开始条件、结束条件
        // 2. 处理

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // cur 和 cur 下一个相同，则移除cur.next(cur.next=cur.next.next)
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                // 不相等，cur则后移
                cur = cur.next;
            }
        }

        return head;
    }

    public ListNode deleteDuplicates3(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }
}
