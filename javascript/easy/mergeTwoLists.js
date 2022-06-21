/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    // 1.
    let result = new ListNode(-1);
    let head = result;
    while (list1 != null && list2 != null) { 
        if (list1.val < list2.val) {
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

    let x = result.next;
    while (x != null) { 
        console.log(x);
        // console.log(x.val);
        x = x.next;
    }

    return result.next;
};

function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

let one = new ListNode(1);
let two = new ListNode(2);
let three = new ListNode(3);
let four = new ListNode(4);

one.next = two;
three.next = four;

console.log(mergeTwoLists(one, three))