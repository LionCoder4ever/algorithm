package main

import "fmt"

type LNode struct {
	data  int
	right *LNode
	down  *LNode
}

func (p *LNode) Insert(head *LNode, data int) *LNode {
	newNode := &LNode{data: data, down: head}
	head = newNode
	return head
}

func CreateNode() *LNode {
	node := &LNode{}
	node = node.Insert(nil, 31)
	node = node.Insert(node, 8)
	node = node.Insert(node, 6)
	node = node.Insert(node, 3)

	node.right = node.Insert(node.right, 21)
	node.right = node.Insert(node.right, 11)

	node.right.right = node.Insert(node.right.right, 50)
	node.right.right = node.Insert(node.right.right, 22)
	node.right.right = node.Insert(node.right.right, 15)

	node.right.right.right = node.Insert(node.right.right.right, 55)
	node.right.right.right = node.Insert(node.right.right.right, 40)
	node.right.right.right = node.Insert(node.right.right.right, 39)
	node.right.right.right = node.Insert(node.right.right.right, 30)
	return node
}

func PrintNode(node *LNode) {
	tmp := node
	for tmp != nil {
		fmt.Print(tmp.data, " ")
		tmp = tmp.down
	}
	fmt.Println()
}

func merge(l1 *LNode, l2 *LNode) *LNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	result := &LNode{}
	if l1.data < l2.data {
		result.data = l1.data
		result.down = merge(l1.down, l2)
	} else {
		result.data = l2.data
		result.down = merge(l1, l2.down)
	}
	return result
}

func flatten(node *LNode) *LNode {
	if node == nil || node.right == nil {
		return node
	}
	node.right = flatten(node.right)
	node = merge(node, node.right)
	return node
}

func main() {
	node := CreateNode()
	PrintNode(node)
	PrintNode(node.right)
	PrintNode(node.right.right)
	PrintNode(node.right.right.right)
	node = flatten(node)
	fmt.Println("after flatten:")
	PrintNode(node)
}
