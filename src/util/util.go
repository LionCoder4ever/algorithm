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

func CreateSortedNodes() (l1, l2 *LNode) {
	l1, l2 = &LNode{}, &LNode{}
	cur := l1
	for i := 0; i < 7; i += 2 {
		cur.Next = &LNode{}
		cur.Next.Data = i + 1
		cur = cur.Next
	}
	cur = l2
	for i := 0; i < 6; i += 2 {
		cur.Next = &LNode{}
		cur.Next.Data = i + 2
		cur = cur.Next
	}
	return
}

func CreateLoopNodes(node *LNode, size, loopStart int) {
	if node == nil || size <= 1 || loopStart < 1 || (loopStart >= size) {
		return
	}
	cur := node
	loopNode := &LNode{}
	for i := 1; i < size; i++ {
		cur.Next = &LNode{}
		cur.Next.Data = i
		cur = cur.Next
		if i == loopStart {
			loopNode = cur
		}
	}
	cur.Next = loopNode
}

func CreateLNodes(node *LNode, size int) {
	cur := node
	for i := 1; i < size; i++ {
		cur.Next = &LNode{}
		cur.Next.Data = i
		cur = cur.Next
	}
}

func CreateLNodesAndReturnSpecified(node *LNode, size, k int) (res *LNode) {
	cur := node
	for i := 1; i < size; i++ {
		cur.Next = &LNode{}
		cur.Next.Data = i
		cur = cur.Next
		if k == i {
			res = cur
		}
	}
	return res
}

func CreateDup(node *LNode, nums []int) {
	for _, v := range nums {
		node.Next = &LNode{v, nil}
		node = node.Next
	}
}
