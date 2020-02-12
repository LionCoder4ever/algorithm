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

func Add(l1, l2 *LNode) (result *LNode) {
	if l1 == nil || l1.Next == nil {
		return l2
	}
	if l2 == nil || l2.Next == nil {
		return l1
	}
	result = &LNode{}
	cur1, cur2 := l1, l2
	r1, cur1, cur2 := result, l1.Next, l2.Next
	tmp, sum := 0, 0
	for cur1 != nil && cur2 != nil {
		r1.Next = &LNode{}
		r1 = r1.Next
		sum = cur1.Data + cur2.Data + tmp
		r1.Data = sum % 10
		tmp = sum / 10
		cur1 = cur1.Next
		cur2 = cur2.Next
	}
	for cur2 != nil {
		r1.Next = &LNode{}
		r1 = r1.Next
		sum = tmp + cur2.Data
		r1.Data = sum % 10
		tmp = sum / 10
		cur2 = cur2.Next
	}
	for cur1 != nil {
		r1.Next = &LNode{}
		r1 = r1.Next
		sum = tmp + cur1.Data
		r1.Data = sum % 10
		tmp = sum / 10
		cur1 = cur1.Next
	}
	if tmp > 0 {
		r1.Next = &LNode{}
		r1.Next.Data = 1
	}

	return
}

func main() {
	l2, l1 := CreateNodes()
	PrintLNodes(l1)
	PrintLNodes(l2)
	result := Add(l1, l2)
	PrintLNodes(result)
}
