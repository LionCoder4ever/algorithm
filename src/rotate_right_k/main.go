package main

import (
	"util"
)

func findLastK(node *util.LNode, n uint) (*util.LNode, *util.LNode) {
	if node == nil || node.Next == nil {
		panic("empty node list")
	}
	fast, slow := node, node
	for n > 0 && fast != nil {
		n--
		fast = fast.Next
	}
	if n > 0 {
		panic("n larger than nodes length")
	}
	for fast.Next != nil {
		slow = slow.Next
		fast = fast.Next
	}
	return slow, fast
}

func RotateRightK(origin, rightKStart, rightKEnd *util.LNode) {
	if origin == nil || origin.Next == nil || rightKStart == nil || rightKStart.Next == nil || rightKEnd == nil {
		return
	}
	tmp := origin.Next
	origin.Next = rightKStart.Next
	rightKEnd.Next = tmp
	rightKStart.Next = nil
}

func main() {
	header := &util.LNode{}
	util.CreateLNodes(header, 8)
	util.PrintLNodes(header)
	rightKStart, rightKEnd := findLastK(header, 3)
	RotateRightK(header, rightKStart, rightKEnd)
	util.PrintLNodes(header)
}
