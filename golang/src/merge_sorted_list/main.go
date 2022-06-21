package main

import . "util"

func MergeNodes(l1, l2 *LNode) *LNode {
	newNode := &LNode{}
	if l1 == nil || l1.Next == nil || l2 == nil || l2.Next == nil {
		return newNode
	}
	header1, header2 := l1.Next, l2.Next
	cur := newNode
	if header1.Data > header2.Data {
		newNode = l2
		cur = header2
		header2 = header2.Next
	} else {
		newNode = l1
		cur = header1
		header1 = header1.Next
	}

	for header1 != nil && header2 != nil {
		if header1.Data > header2.Data {
			cur.Next = header2
			cur = header2
			header2 = header2.Next
		} else {
			cur.Next = header1
			cur = header1
			header1 = header1.Next
		}
	}
	if header1 == nil {
		cur.Next = header2
	}
	if header2 == nil {
		cur.Next = header1
	}
	return newNode
}

func main() {
	l1, l2 := CreateSortedNodes()
	PrintLNodes(l1)
	PrintLNodes(l2)
	PrintLNodes(MergeNodes(l1, l2))
}
