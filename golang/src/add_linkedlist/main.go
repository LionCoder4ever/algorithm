package main

import . "util"

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
