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
	l := new(SliceQueue)
	l.EnQueue(1)
	l.EnQueue(2)
	fmt.Println(l.GetFront())
	fmt.Println(l.GetBack())
	fmt.Println(l.Size())
}
