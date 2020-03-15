package util

type stack interface {
	Pop() int
	Push(data int)
	Size() int
	Top() int
	isEmpty() bool
}

type SliceStack struct {
	Arr       []int
	StackSize int
}

func (s *SliceStack) Pop() (result int) {
	if s.IsEmpty() {
		panic("empty stack")
	}
	s.StackSize--
	result = s.Arr[s.StackSize]
	s.Arr = s.Arr[:s.StackSize]
	return
}

func (s *SliceStack) Push(data int) {
	s.StackSize++
	s.Arr = append(s.Arr, data)
}

func (s *SliceStack) Size() int {
	return s.StackSize
}

func (s *SliceStack) Top() int {
	if s.IsEmpty() {
		panic("empty stack")
	}
	return s.Arr[s.StackSize-1]
}

func (s *SliceStack) IsEmpty() bool {
	return s.StackSize == 0
}

type LinkedStack struct {
	head *LNode
}

func (p *LinkedStack) Pop() int {
	tmp := p.head.Next
	if tmp != nil {
		p.head.Next = tmp.Next
		return tmp.Data
	}
	panic("empty stack")
}

func (p *LinkedStack) Push(data int) {
	p.head.Next = &LNode{data, p.head.Next}
}

func (p *LinkedStack) Top() int {
	if p.head.Next != nil {
		return p.head.Next.Data
	}
	panic("empty stack")
}

func (p *LinkedStack) isEmpty() bool {
	return p.head.Next != nil
}

func (p *LinkedStack) IsEmpty() bool {
	return p.head.Next == nil
}

func (p *LinkedStack) Size() (size int) {
	node := p.head.Next
	for node != nil {
		node = node.Next
		size++
	}
	return
}
