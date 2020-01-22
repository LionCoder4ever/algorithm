package main

import (
	"fmt"
)

type LNode struct {
	Data int
	Next *LNode
}

func CreateLNodes(node *LNode, size int) {
	cur := node
	for i := 1; i < size; i++ {
		cur.Next = &LNode{}
		cur.Next.Data = i
		cur = cur.Next
	}
}

func PrintLNodes(node *LNode) {
	for cur := node.Next; cur != nil; cur = cur.Next {
		fmt.Printf("%d  ", cur.Data)
	}
	fmt.Println()
}

func Reverse(node *LNode) {
	if node == nil || node.Next == nil {
		return
	}
	// pre, next node init value nil
	var pre, next *LNode
	// first cur node is headNode's next node
	cur := node.Next
	for cur != nil {
		next = cur.Next
		cur.Next = pre
		pre = cur
		cur = next
	}
	node.Next = pre
}

func RecursiveReverseChild(node *LNode) *LNode {
	if node == nil || node.Next == nil {
		return node
	}
	newHeader := RecursiveReverseChild(node.Next)
	node.Next.Next = node
	node.Next = nil
	return newHeader
}

func RecursiveReverse(node *LNode) {
	header := node.Next
	node.Next = RecursiveReverseChild(header)
}

func InsertReverse(node *LNode) {
	if node == nil || node.Next == nil {
		return
	}
	var cur, next *LNode
	cur = node.Next.Next
	// move the first node to last
	node.Next.Next = nil
	for cur != nil {
		// save the next node
		next = cur.Next
		// put the first node after cur
		cur.Next = node.Next
		// put the cur after the header
		node.Next = cur
		cur = next
	}
}

func main() {
	head := &LNode{}
	CreateLNodes(head, 5)
	PrintLNodes(head)
	Reverse(head)
	PrintLNodes(head)

	CreateLNodes(head, 7)
	PrintLNodes(head)
	RecursiveReverse(head)
	PrintLNodes(head)

	CreateLNodes(head, 9)
	PrintLNodes(head)
	InsertReverse(head)
	PrintLNodes(head)
}
