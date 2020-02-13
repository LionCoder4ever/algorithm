package main

import (
	"fmt"
	. "util"
)

func findLastK(node *LNode, k int) *LNode {
	if node == nil || node.Next == nil {
		return node
	}
	fast, slow := node.Next, node.Next
	for i := 0; i < k; i++ {
		fast = fast.Next
	}
	for fast != nil {
		fast = fast.Next
		slow = slow.Next
	}
	return slow
}

func main() {
	header := &LNode{}
	CreateLNodes(header, 8)
	PrintLNodes(header)
	result := findLastK(header, 3)
	fmt.Println(result.Data)
}
