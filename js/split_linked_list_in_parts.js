/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} root
 * @param {number} k
 * @return {ListNode[]}
 */
var splitListToParts = function(root, k) {
    if (root == null){
        return new Array(k).fill(null)
    }
    let listlen = 0
    let node = root
    while(node != null){
        listlen++
        node = node.next
    }
       // start split
    let result = []
    if (k >= listlen) {
        while(root != null) {
            result.push(root)
            root = splitList(root)
        }
        while(result.length < k) {
            result.push(null)
        }
    } else {
        let partlen = 0, extraparts = 0
        partlen = Math.floor(listlen / k) + 1
        extraparts = listlen % k
        for (let j = 0; j < k; j++) {
                if (j == extraparts) {
                    partlen--      
                }
                result.push(root)
                for (let l = 1; l < partlen; l++) {
                    root = root.next
                }
                root = splitList(root)
            }
    }
    return result
    // for (let j = 0; j < extraparts; j++) {
    //     result.push(root)
    //     for (let l = 0; l < partlen; l++) {
    //         root = root.next
    //     }
    //     root = splitList(root)
    // }
    // if (listlen < k){
    //     for (let l = 0; l < k-extraparts; l++) {
    //         result.push(null) 
    //     }
    //     return result
    // }
    // while (root != null){
    //     result.push(root)
    //     for (let l = 0; l < partlen - 1; l++) {
    //         root = root.next
    //     }
    //     root = splitList(root)
    // }
    // return result
};
let splitList = function(root){
    let tmp = root.next
    root.next = null
    return tmp
}

 function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

// [1, 2, 3], k = 5
let a = new ListNode(1, new ListNode(2, new ListNode(3, null)))

let result = splitListToParts(a, 5)
console.log(result)

a = new ListNode(1, new ListNode(2, new ListNode(3, 
    new ListNode(4, 
    new ListNode(5, 
    new ListNode(6, 
    new ListNode(7, 
    new ListNode(8, 
    new ListNode(9, 
    new ListNode(10, 
        ))))))))))

result = splitListToParts(a, 3)
console.log(result)

a = new ListNode(1, new ListNode(2, new ListNode(3, 
    new ListNode(4, 
        ))))

result = splitListToParts(a, 5)
console.log(result)

a = new ListNode(0, undefined)

result = splitListToParts(a, 2)
console.log(result)

a = null

result = splitListToParts(a, 3)
console.log(result)