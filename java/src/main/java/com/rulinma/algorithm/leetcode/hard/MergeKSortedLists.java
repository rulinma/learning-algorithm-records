package com.rulinma.algorithm.leetcode.hard;

import com.rulinma.algorithm.leetcode.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @author 马如林
 * @Data 2022/6/22 16:22
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        // 我们简单是因为有PrioriQueue
        // 1. 创建一个ListNode
        // 2. K个ListNode放入PrioriQueue
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            head.next = node;
            head = head.next;

            if (node.next != null) {
                priorityQueue.add(node.next);
            }
        }

        return dummy.next;
    }


}
