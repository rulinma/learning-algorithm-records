package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 2. 两数相加
 * <p>
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * https://leetcode.cn/problems/add-two-numbers
 *
 * @author 马如林
 * @Data 2022/7/5 15:20
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode result = head;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int v = v1 + v2 + carry;
            if (v >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            head.next = new ListNode(v % 10);
            head = head.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry == 1) {
            head.next = new ListNode(1);
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        ListNode l1_3 = new ListNode(3);
        l1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2 = new ListNode(5);
        ListNode l2_2 = new ListNode(6);
        ListNode l2_3 = new ListNode(4);
        l2.next = l2_2;
        l2_2.next = l2_3;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);

        System.out.println(result);
    }

}
