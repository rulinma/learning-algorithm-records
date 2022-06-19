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
public class MergeTwoSortedLists {

    /**
     * 首先，设定一个虚拟节点 dummy 用来存储结果，循环对比 L1 和 L2 节点上的数字，通过调整 p节点的 next 指针来调整 dummy 的结果。
     * 如果 L1 当前位置的值小于等于 L2 ，我们就把  L1 的值接在  dummy 节点的后面同时将  L1 指针往后移一个
     * 如果 L2 当前位置的值小于 L2 ，我们就把  L2 的值接在  p 节点的后面同时将  L2 指针往后移一个
     * 不管我们将哪一个元素接在了 p 节点后面，都需要向后移一个元素
     * 重复以上过程，直到  L1 或者  L2 指向了 null
     * 在循环终止的时候，  L1 和  L2 至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表。
     * <p>
     * 算法空间复杂度 O1，时间复杂度 O（n + m）
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
        // 添加一个新链表当前指针位置的变量
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
