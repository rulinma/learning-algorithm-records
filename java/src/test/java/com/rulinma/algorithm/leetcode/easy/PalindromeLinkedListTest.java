package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/22 18:37
 */
public class PalindromeLinkedListTest {

    @Test
    public void testPalindromeLinkedList() {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode head = new ListNode(1);

        ListNode two = new ListNode(2);
        ListNode three = new ListNode(1);
        head.next = two;
//        two.next = three;

        boolean result = palindromeLinkedList.isPalindrome(head);
        System.out.println(result);

    }
}
