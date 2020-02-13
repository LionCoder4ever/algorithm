package main

import "fmt"

func PrintLNodes(node *LNode) {
	for cur := node.Next; cur != nil; cur = cur.Next {
		fmt.Printf("%d  ", cur.Data)
	}
	fmt.Println()
}

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
