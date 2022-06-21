/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {

    return head;
};

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

console.log(reverseList())