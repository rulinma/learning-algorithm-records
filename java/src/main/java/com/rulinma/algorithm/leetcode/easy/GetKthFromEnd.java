package com.rulinma.algorithm.leetcode.easy;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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

        int count = len - k;

        ListNode cur = head;
        while (count > 0) {
            cur = cur.next;
            count--;
        }

//        int i = 0;
//        while(i<count) {
//            cur = cur.next;
//            i++;
//        }

        return cur;
    }

}
