/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    let n = lists.length
    if (n < 1) {
        return []
    }
    if (n == 1) {
        return  lists[0]
    }
    return mergeCore(lists,0,lists.length-1)
};

var mergeCore = function(lists, p, r) {
    if ( p >= r ) {
        return lists[p] 
    } else if (p + 1 == r) {
        return merge2Lists(lists[p],lists[r])
    }
    let q =  Math.floor((p+r)/2)
    let l1 = mergeCore(lists, p, q)
    let l2 = mergeCore(lists, q+1, r)
    return merge2Lists(l1,l2)
}

var merge2Lists = function(first, second) {
    if (!first || !second) {
        return
    }
    let header = new ListNode()
    let node = header
    while (first != null && second != null){
        if (first.val > second.val){
            node.next = second
            second = second.next
        } else {
            node.next = first
            first = first.next
        }
        node = node.next
    }
    if (first != null) {
        node.next = first
    }
    if (second != null) {
        node.next = second
    }
    return header.next
}

// function PrintNodes(list) {
//     while(list != null){
//         console.log(list.val)
//         list = list.next
//     }
// }

// function ListNode(val, next) {
//       this.val = (val===undefined ? 0 : val)
//       this.next = (next===undefined ? null : next)
// }

// let first = new ListNode(1,  undefined)
// first.next = new ListNode(3, undefined)
// first.next.next = new ListNode(9, undefined)

// let second = new ListNode(2,  undefined)
// second.next = new ListNode(4, undefined)
// second.next.next = new ListNode(6, undefined)

// let thrid = new ListNode(10,  undefined)
// thrid.next = new ListNode(11, undefined)
// thrid.next.next = new ListNode(12, undefined)

// let a = [first,second,thrid]


// let b = mergeKLists(a)

// PrintNodes(b)



/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    let n = lists.length
    if (n < 1) {
        return null
    }
    if (n == 1) {
        return  lists[0]
    }
    return mergeCore(lists,0,lists.length-1)
};

var mergeCore = function(lists, p, r) {
    if ( p >= r ) {
        return lists[p]
    } else if (p + 1 == r) {
        return merge2Lists(lists[p],lists[r])
    }
    let q =  Math.floor((p+r)/2)
    let l1 = mergeCore(lists, p, q)
    let l2 = mergeCore(lists, q+1, r)
    return merge2Lists(l1,l2)
}

var merge2Lists = function(first, second) {
    if (!first && second) {
        return second
    } else if (first && !second) {
        return first
    } else if (!first && !second) {
        return null
    }
    let header = new ListNode()
    let node = header
    while (first != null && second != null){
        if (first.val > second.val){
            node.next = second
            second = second.next
        } else {
            node.next = first
            first = first.next
        }
        node = node.next
    }
    if (first != null) {
        node.next = first
    }
    if (second != null) {
        node.next = second
    }
    return header.next
}

// function PrintNodes(list) {
//     while(list != null){
//         console.log(list.val)
//         list = list.next
//     }
// }

// function ListNode(val, next) {
//       this.val = (val===undefined ? 0 : val)
//       this.next = (next===undefined ? null : next)
// }

// let first = new ListNode(1,  undefined)
// first.next = new ListNode(3, undefined)
// first.next.next = new ListNode(9, undefined)

// let second = new ListNode(2,  undefined)
// second.next = new ListNode(4, undefined)
// second.next.next = new ListNode(6, undefined)

// let thrid = new ListNode(10,  undefined)
// thrid.next = new ListNode(11, undefined)
// thrid.next.next = new ListNode(12, undefined)

// let a = [first,second,thrid]


// let b = mergeKLists(a)

// PrintNodes(b)