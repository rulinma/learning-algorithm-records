package com.rulinma.algorithm.leetcode.middle;

import com.rulinma.algorithm.leetcode.common.Node;

/**
 * 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * <p>
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * <p>
 * 返回复制链表的头节点。
 * <p>
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * <p>
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 * 提示：
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random 为 null 或指向链表中的节点。
 * <p>
 * https://leetcode.cn/problems/copy-list-with-random-pointer
 *
 * @author 马如林
 * @Data 2022/6/29 11:23
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        // deep clone
        Node dummy = new Node(-1);

        Node pos = dummy;
        Node cur = head;
        // 遍历添加
        while (cur != null) {
            Node tmp = new Node(cur.val);
            pos.next = tmp;
            pos = pos.next;

            cur = cur.next;
        }

        // 遍历设置random
        cur = head;
        Node newHead = dummy.next;
        Node newCur = newHead;
        while (cur != null && newCur != null) {
            if (cur.random != null) {
                int index = getRandomNodeIndex(head, cur.random);
                // set dummy 的该值
                newCur.random = getNode(newHead, index);
            } else {
                newCur.random = null;
            }
            cur = cur.next;
            newCur = newCur.next;
        }

        return dummy.next;
    }

    private int getRandomNodeIndex(Node node, Node random) {
        int i = 0;
        while (node != null && random != node) {
            node = node.next;
            i++;
        }

        return i;
    }

    private Node getNode(Node node, int index) {
        int i = 0;

        while (i < index && node != null) {
            node = node.next;
            i++;
        }

        return node;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Node result = copyListWithRandomPointer.copyRandomList(node1);
        System.out.println(result);
    }

}
