package main

import . "util"

func Reverse(node *LNode) *LNode {
	if node == nil || node.Next == nil {
		return node
	}
	var tmp, pre *LNode
	for node != nil {
		tmp = node.Next
		node.Next = pre
		pre = node
		node = tmp
	}
	return pre
}

func FindMiddeleNode(node *LNode) *LNode {
	if node == nil || node.Next == nil {
		return node
	}
	fast, slow := node, node
	var slowPre *LNode
	for fast != nil && fast.Next != nil {
		slowPre = slow
		slow = slow.Next
		fast = fast.Next.Next
	}
	// split the nodes
	slowPre.Next = nil
	return slow
}

func Resort(node *LNode) {
	if node == nil || node.Next == nil {
		return
	}
	cur := node.Next
	//// reverse node
	//// get size of list
	//len := 0
	//for cur.Next != nil {
	//	len++
	//	cur = cur.Next
	//}
	//cur = node
	//for i:=0; i < len / 2;i++ {
	//	cur = cur.Next
	//}
	//// the second list header
	//l2 := cur.Next
	//cur.Next = nil
	//// reverse l2
	//cur = node.Next
	l2 := FindMiddeleNode(node.Next)
	rl2 := Reverse(l2)
	var tmp *LNode
	for cur.Next != nil {
		tmp = cur.Next
		cur.Next = rl2
		cur = tmp
		tmp = rl2.Next
		rl2.Next = cur
		rl2 = tmp
	}
	cur.Next = rl2
}

func main() {
	header := &LNode{}
	CreateLNodes(header, 8)
	PrintLNodes(header)
	Resort(header)
	PrintLNodes(header)
}
