package main

import (
	"fmt"
	. "util"
)

func main() {
	defer func() {
		if err := recover(); err != nil {
			fmt.Println(err)
		}
	}()
	l := SliceStack{Arr: make([]int, 0), StackSize: 0}
	l.Push(1)
	fmt.Println(l.Top())
	fmt.Println(l.Size())
	l.Pop()
	fmt.Println(l.Size())
	l.Pop()
}
