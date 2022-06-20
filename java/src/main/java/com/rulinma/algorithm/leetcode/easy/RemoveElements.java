package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * <p>
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author 马如林
 * @Data 2022/6/20 11:13
 */
public class RemoveElements {

    /**
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * <p>
     * 空间复杂度：O(1)。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        // 1. 遍历所有node，head为空结束
        // 2. 如果当前node的next值==value，node的.next设置为一下个node

        // 添加dummy节点，返回dummy的.next

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else if (cur.next.val != val) {
                cur = cur.next;
            }
        }

        return dummyNode.next;
    }

}
