package main

import (
	"fmt"
	. "util"
)

func hasLoop(node *LNode) (bool, *LNode) {
	if node == nil || node.Next == nil {
		return false, node
	}
	fast, slow := node.Next, node.Next
	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if fast == slow {
			return true, slow
		}
	}
	return false, node
}

func findLoopStart(node *LNode) (bool, *LNode) {
	if ok, meetNode := hasLoop(node); ok == true {
		node = node.Next
		for {
			meetNode = meetNode.Next
			node = node.Next
			if meetNode == node {
				return true, meetNode
			}
		}
	}
	return false, node
}

func main() {
	header := &LNode{}
	CreateLoopNodes(header, 15, 6)
	noLoopHeader := &LNode{}
	CreateLNodes(noLoopHeader, 15)
	fmt.Println(findLoopStart(header))
	fmt.Println(findLoopStart(noLoopHeader))
}
