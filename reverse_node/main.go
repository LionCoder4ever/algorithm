package main

import "fmt"

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

func main() {
	head := &LNode{}
	CreateLNodes(head, 5)
	PrintLNodes(head)
	Reverse(head)
	PrintLNodes(head)
}
