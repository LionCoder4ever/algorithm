package util

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
