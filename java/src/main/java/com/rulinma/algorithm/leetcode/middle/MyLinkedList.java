package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.ListNode;

/**
 * 707. 设计链表
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * https://leetcode.cn/problems/design-linked-list
 *
 * @author 马如林
 * @Data 2022/6/28 14:11
 */
public class MyLinkedList {
    private ListNode head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        int i = 0;
        ListNode pos = head;
        while (pos != null) {
            if (i == index) {
                return pos.val;
            }
            i++;
            pos = pos.next;
        }

        return -1;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode t = new ListNode(val);
            t.next = head;
            head = t;
        }
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            // traver to tail
            ListNode t = new ListNode(val);
            ListNode pos = head;
            while (pos.next != null) {
                pos = pos.next;
            }
            pos.next = t;
        }
    }

    public void addAtIndex(int index, int val) {
        // 首位
        // 中间
        // 末尾
        if (index == 0) {
            ListNode t = new ListNode(val);
            t.next = head;
            head = t;
            return;
        }

        ListNode pos = head;
        int i = 0;
        while (pos != null) {
            if (i == index - 1) {
                ListNode next = pos.next;
                ListNode t = new ListNode(val);
                pos.next = t;
                t.next = next;
            }
            i++;
            pos = pos.next;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }

        ListNode pos = head;
        ListNode pre = null;
        int i = 0;
        while (pos != null) {
            if (i == index) {
                // 末尾
                if (pos.next == null) {
                    pre.next = null;
                } else {
                    // 中间
                    pre.next = pos.next;
                }
            }
            i++;
            pre = pos;
            pos = pos.next;
        }

    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        int r1 = linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        int r3 = linkedList.get(1);            //返回3

        MyLinkedList head = linkedList;

    }
}
