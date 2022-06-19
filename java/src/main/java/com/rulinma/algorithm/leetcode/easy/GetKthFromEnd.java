package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * @author 马如林
 * @Data 2022/6/19 21:46
 */
public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 1. 获取长度len
        // 2. 倒数第k个就是正数len-k(从0开始)
        int len = 0;
        ListNode current = head;

        while (current != null) {
            len++;
            current = current.next;
        }

        int index = len - k;

        ListNode cur = head;
        while (index > 0) {
            cur = cur.next;
            index--;
        }

        return cur;
    }

}
