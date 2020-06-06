/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} m
 * @param {number} n
 * @return {ListNode}
 */
var reverseBetween = function(head, m, n) {
    let newHeader = new ListNode(-1,head)
    let i = 0
   let node = newHeader , pre = newHeader
   while (node.next != null){
       if (i == m){
        break
       }
    pre = node
    node = node.next
    i++
   }
   let reveStart = pre
   let start = node
   let next,j=0
   while(start != null && (j!=(n-m+1))){
    next = start.next
    start.next = pre
    pre = start 
    start = next
    j++
   }
    reveStart.next = pre
   node.next = start
   return newHeader.next
}
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
};

function list(l){
    let node = l
    while(node != null){
        console.log(node.val)
        node = node.next
    }
    console.log('null')
}
let a = new ListNode(1,null)
a.next = new ListNode(2,
    new ListNode(3, new ListNode(4, new ListNode(5, undefined))))

list(a)

console.log('---------------')
a = reverseBetween(a,2,4)

list(a)


console.log('============')

let b = new ListNode(3,null)
b.next = new ListNode(5,undefined)

list(b)

console.log('---------------')

b= reverseBetween(b,1,2)

list(b)
