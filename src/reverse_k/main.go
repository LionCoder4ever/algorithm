package main

import . "util"

func Reverse(node *LNode) *LNode {
	if node == nil || node.Next == nil {
		return node
	}
	var pre, next, cur *LNode
	cur = node
	for cur != nil {
		next = cur.Next
		cur.Next = pre
		pre = cur
		cur = next
	}
	return pre
}

func ReverseK(node *LNode, k uint) {
	if node == nil || node.Next == nil || k <= 1 {
		return
	}
	var header, start, end, nextKStart *LNode
	header = node
	start = node.Next
	for end != nil {
		end = start
		i := uint(0)
		for ; i < (k-1) && end != nil; i++ {
			end = end.Next
		}
		if i != (k - 1) {
			break
		}
		nextKStart = end.Next
		end.Next = nil
		header.Next = Reverse(start)
		start.Next = nextKStart
		header = start
		start = nextKStart
	}
}

func main() {
	header := &LNode{}
	CreateLNodes(header, 8)
	PrintLNodes(header)
	ReverseK(header, 3)
	PrintLNodes(header)
}
