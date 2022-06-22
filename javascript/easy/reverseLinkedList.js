/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author 马如林
 * @Data 2022/6/21 22:40
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    let pre = head;
    let cur = null;
    while (pre != null) { 
        let next = pre.next;
        pre.next = cur;
        cur = pre;
        pre = next;
    }

    return cur;
};

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

console.log(reverseList())