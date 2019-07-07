package main

import (
	"base"
	"container/list"
	"fmt"
	"pipline"
	"time"
)

func sm()  {
	now := time.Now().Unix()
	fmt.Print(now)
	i := list.New()
	for sp:=0;sp<9999999; sp=sp+1 {
		i.PushFront(sp)
	}

	producer := pipline.Producer(i)
	/*ch := pipline.Squre(producer)

	for ret := range ch {
		fmt.Println( ret)
	}*/



	c1 := pipline.Squre(producer)
	c2 := pipline.Squre(producer)
	c3 := pipline.Squre(producer)
	c4 := pipline.Squre(producer)
	c5 := pipline.Squre(producer)
	c6 := pipline.Squre(producer)
	c7 := pipline.Squre(producer)
	c8 := pipline.Squre(producer)
	c9 := pipline.Squre(producer)
	c10 := pipline.Squre(producer)
	c11 := pipline.Squre(producer)
	c12 := pipline.Squre(producer)
	c13 := pipline.Squre(producer)
	c14 := pipline.Squre(producer)

	ret :=pipline.Merge(c1, c2, c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14)
	for rr:= range ret {
		fmt.Println(rr)
	}
	// consumer
	//for ret := range pipline.Merge(c1, c2, c3) {
	//fmt.Println(ret)
	//}
	fmt.Println()

	fmt.Println("======",time.Now().Unix()-now)

}

func mpline()  {
	n:=map[string]int{
		"b":1,
		"a":2,
	}

	if v,ok:=n["a"]; ok {
		print(v)
	}
}

func main()  {
	base.T1()
}
