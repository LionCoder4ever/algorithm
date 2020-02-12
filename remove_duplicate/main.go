package main

import "fmt"

type LNode struct {
	Data int
	Next *LNode
}

func RemoveDup(node *LNode) {
	if node == nil || node.Next == nil {
		return
	}
	for outer := node.Next; outer != nil && outer.Next != nil; outer = outer.Next {
		for innerPre, inner := outer, outer.Next; inner != nil; {
			if inner.Data == outer.Data {
				innerPre.Next = inner.Next
				inner = inner.Next
			} else {
				innerPre = inner
				inner = inner.Next
			}
		}
	}
}

func RemoveDupRecursionChild(node *LNode) *LNode {
	if node == nil || node.Next == nil {
		return node
	}
	node.Next = RemoveDupRecursionChild(node.Next)
	pre, finder := node, node.Next
	for finder != nil {
		if node.Data == finder.Data {
			pre.Next = finder.Next
			finder = pre.Next
		} else {
			finder = finder.Next
			pre = pre.Next
		}
	}
	return node
}

func RemoveDupRecursion(node *LNode) {
	if node == nil {
		return
	}
	node.Next = RemoveDupRecursionChild(node.Next)
}

func PrintLNodes(node *LNode) {
	for cur := node.Next; cur != nil; cur = cur.Next {
		fmt.Printf("%d  ", cur.Data)
	}
	fmt.Println()
}

func main() {
	header := &LNode{}
	nums := []int{1, 3, 1, 5, 5, 7}
	createDup(header, nums)
	PrintLNodes(header)
	//RemoveDup(header)
	RemoveDupRecursion(header)
	PrintLNodes(header)
}

func createDup(node *LNode, nums []int) {
	for _, v := range nums {
		node.Next = &LNode{v, nil}
		node = node.Next
	}
}
