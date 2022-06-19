package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 *
 * @author 马如林
 * @Data 2022/6/19 17:46
 */
public class mergeTwoSortedLists {

    /**
     * 1. 创建一个新链表
     * 2. 比较1和2的头结点，选择小的添加到新链表，1或者2指针前进直到为空
     * 3. 为空则把未遍历完的链表指针添加到新链表尾部即可
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1. 创建新链表并使用一个head节点
        // 2. 添加节点
        // 2.1 1和2都不为空，比较当前1和2的头结点大小，选择小的添加到新链表，并且移动该节点指针到下一个
        // 2.2 1或2为空，添加非空链表的头结点到新链表末尾
        // 3. 返回新链表未head节点的指针

        ListNode result = new ListNode(-1);
        ListNode head = result;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // new
                head.next = list1;
                // 指针后移
                list1 = list1.next;
            } else {
                head.next = list2;
                // 指针后移
                list2 = list2.next;
            }
            head = head.next;
        }

        if (list1 == null) {
            head.next = list2;
        }

        if (list2 == null) {
            head.next = list1;
        }

        return result.next;
    }

}
