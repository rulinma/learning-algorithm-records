/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    // 1.
    let result = new ListNode(-1);
    let head = result;
    while (list1 != null && list2 != null) { 
        if (list1.val > list2.val) {
            head.next = list1;
            list1 = list1.next;
        } else { 
            head.next = list2;
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
};

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

console.log(reverseList())