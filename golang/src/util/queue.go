package util

type queue interface {
	IsEmpty() bool
	Size() int
	GetFront() int
	GetBack() int
	DeQueue()
	EnQueue(data int)
}

type SliceQueue struct {
	arr   []int
	front int
	rear  int
}

func (p *SliceQueue) Rear() int {
	return p.rear
}

func (p *SliceQueue) SetRear(rear int) {
	p.rear = rear
}

func (p *SliceQueue) Front() int {
	return p.front
}

func (p *SliceQueue) SetFront(front int) {
	p.front = front
}

func (p *SliceQueue) Arr() []int {
	return p.arr
}

func (p *SliceQueue) SetArr(arr []int) {
	p.arr = arr
}

func (p *SliceQueue) Size() int {
	return p.rear - p.front
}

func (p *SliceQueue) GetFront() int {
	if p.IsEmpty() {
		panic("empty queue")
	}
	return p.arr[p.front]
}

func (p *SliceQueue) GetBack() int {
	if p.IsEmpty() {
		panic("empty queue")
	}
	return p.arr[p.rear-1]
}

func (p *SliceQueue) DeQueue() {
	if p.rear > p.front {
		p.rear--
		p.arr = p.arr[1:]
	} else {
		panic("empty queue")
	}
}

func (p *SliceQueue) EnQueue(data int) {
	p.arr = append(p.arr, data)
	p.rear++
}

func (p *SliceQueue) IsEmpty() bool {
	return p.front == p.rear
}
