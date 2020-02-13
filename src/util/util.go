package util

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

func CreateNodes() (l1, l2 *LNode) {
	l1, l2 = &LNode{}, &LNode{}
	cur := l1
	for i := 1; i < 7; i++ {
		cur.Next = &LNode{}
		cur.Next.Data = i + 2
		cur = cur.Next
	}
	cur = l2
	for i := 9; i > 4; i-- {
		cur.Next = &LNode{}
		cur.Next.Data = i
		cur = cur.Next
	}
	return
}

func CreateLNodes(node *LNode, size int) {
	cur := node
	for i := 1; i < size; i++ {
		cur.Next = &LNode{}
		cur.Next.Data = i
		cur = cur.Next
	}
}

func CreateDup(node *LNode, nums []int) {
	for _, v := range nums {
		node.Next = &LNode{v, nil}
		node = node.Next
	}
}
