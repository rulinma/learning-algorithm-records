package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/21 22:52
 */
public class ReverseLinkedListTest {

    @Test
    public void testReverseLinkedList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        head.next = two;
        two.next = three;

        ListNode result = reverseLinkedList.reverseList(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
