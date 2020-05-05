/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let header = conver2LinkedList(s)
    // find middle
    let middle = findMiddle(header)
    // reverse the last linked list
    let lastListHeader = reverseLinkedList(middle)
    // loopNode
    let firstListHeader = header
    while (lastListHeader!= null && firstListHeader!=null) {
        if (lastListHeader.value != firstListHeader.value) {
            return false
        }
        lastListHeader = lastListHeader.next
        firstListHeader = firstListHeader.next
    }
    if (lastListHeader == null && firstListHeader == null) {
        return true
    }
    return false
    // printLinkedNode(header)
    // compare
};

var findMiddle = function(header) {
    if (header == null || header.next == null) {
        return new LinkedList('', null)
    }
    let slowPoint = header.next, fastPoint = header.next, preSlowPoint = header
    let isOdd = true
    while (fastPoint.next != null) {
        fastPoint = fastPoint.next
        if (fastPoint.next == null) {
            isOdd = false
            break
        } else {
            fastPoint = fastPoint.next
        }
        preSlowPoint = slowPoint
        slowPoint = slowPoint.next
    }
    let middle
    middle = new LinkedList('', slowPoint.next)
    if (isOdd) {
        preSlowPoint.next = null
    } else {
        slowPoint.next = null
    }
    return middle
}

var conver2LinkedList = function(s){
    header = new LinkedList('',null)
    node = header
    for (const alpha of s) {
        if (alpha >= 'A' && alpha <= 'Z') {
            node.next = new LinkedList(alpha.toLowerCase(), null)
        } else if ((alpha >= 'a' && alpha <= 'z') ||(alpha >= '0' && alpha <= '9')) {
            node.next = new LinkedList(alpha, null)
        } else {
            continue
        }
        node = node.next
    }
    return header
}

var reverseLinkedList = function(header) {
    if (header == null || header.next == null) {
        return new LinkedList('', null)
    }
    let pre = header.next
    let newTail = pre
    let current = pre.next
    while (current != null) {
        let next = current.next
        current.next = pre
        pre = current
        current = next
    }
    newTail.next = null
    return new LinkedList('', pre)
}

var printLinkedNode = function(header){
    let start = header.next
    let saveNode = start
    while (start != null) {
        console.log(start.value)
        start = start.next
    }
    header.next = saveNode
}

class LinkedList {
    constructor(value, next) {
        this.value = value
        this.next = next
    }
}
