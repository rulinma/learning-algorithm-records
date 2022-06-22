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