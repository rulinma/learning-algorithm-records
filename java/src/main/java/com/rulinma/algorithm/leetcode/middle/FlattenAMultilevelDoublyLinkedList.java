package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.pre.child.Node;

/**
 * 430. 扁平化多级双向链表
 *
 * @author 马如林
 * @Data 2022/7/5 18:24
 */
public class FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        for (; head != null; head = head.next) {
            if (head.child != null) {
                Node tmp = head.next;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = tmp;
                if (tmp != null) {
                    tmp.prev = last;
                }
            }
        }

        return dummy.next;
    }

}
