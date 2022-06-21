package main

import . "util"

func DelSpecifiedNode(node, specified *LNode) {
	if node == nil || specified == nil || specified.Next == nil {
		return
	}
	specified.Data = specified.Next.Data
	specified.Next = specified.Next.Next
}

func main() {
	header := &LNode{}
	specified := CreateLNodesAndReturnSpecified(header, 8, 5)
	PrintLNodes(header)
	DelSpecifiedNode(header, specified)
	PrintLNodes(header)
}
