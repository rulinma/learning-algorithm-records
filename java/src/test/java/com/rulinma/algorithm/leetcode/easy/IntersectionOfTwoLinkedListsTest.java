package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author 马如林
 * @Data 2022/6/22 15:02
 */
@Slf4j
public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void testIntersectionOfTwoLinkedLists() {
        ListNode headA = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        headA.next = a1;
        a1.next = a2;

        ListNode headB = new ListNode(11);
        ListNode b1 = new ListNode(22);
//        ListNode b2 = new ListNode(33);
        headB.next = b1;
        b1.next = a2;

        IntersectionOfTwoLinkedLists intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        ListNode result = intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB);
        log.info("result {} ", result);
    }
}
