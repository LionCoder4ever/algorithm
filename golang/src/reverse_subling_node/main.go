package main

import . "util"

func ReverseSublingNodes(node *LNode) {
	if node == nil || node.Next == nil {
		return
	}
	tmp, pre, cur := node, node, node.Next

	for cur != nil && cur.Next != nil {
		pre.Next = cur.Next
		tmp = pre.Next.Next
		pre.Next.Next = cur
		cur.Next = tmp
		pre = cur
		cur = cur.Next
	}
}

func main() {
	header := &LNode{}
	CreateLNodes(header, 8)
	PrintLNodes(header)
	ReverseSublingNodes(header)
	PrintLNodes(header)
}
