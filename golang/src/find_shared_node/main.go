package main

import (
	"fmt"
	. "util"
)

func FindSharedNode(l1, l2 *LNode) (bool, *LNode) {
	if l1 == nil || l1.Next == nil || l2 == nil || l2.Next == nil {
		return false, &LNode{}
	}
	var cur1, cur2, lastNode *LNode
	length1, length2 := 0, 0
	cur1 = l1
	cur2 = l2
	for cur1.Next != nil {
		cur1 = cur1.Next
		length1++
	}
	lastNode = cur1
	for cur2.Next != nil {
		cur2 = cur2.Next
		length2++
	}
	if lastNode == cur2 {
		cur1 = l1
		cur2 = l2
		if length1 > length2 {
			for i := 0; i < length1-length2; i++ {
				cur1 = cur1.Next
			}
		} else {
			for i := 0; i < length2-length1; i++ {
				cur2 = cur2.Next
			}

			for cur1.Next != nil && cur2.Next != nil {
				if cur1 == cur2 {
					return true, cur1
				}
				cur1 = cur1.Next
				cur2 = cur2.Next
			}
		}
	} else {
		return false, &LNode{}
	}

	return false, &LNode{}
}

func main() {
	l1 := &LNode{}
	CreateLNodes(l1, 5)
	l2 := &LNode{}
	CreateLNodes(l2, 15)
	cur := l2
	for cur.Next != nil {
		cur.Data = cur.Data + 20
		cur = cur.Next
	}
	cur.Next = l1.Next.Next
	//  shared start 2
	PrintLNodes(l1)
	PrintLNodes(l2)
	if ok, shared := FindSharedNode(l1, l2); ok {
		fmt.Println("the two linked list share the nodes start at", shared)
	}
}
