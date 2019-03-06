package main

import (
	"awesomeProject/src/sp/upload"
	"flag"
	"fmt"
	"github.com/kataras/iris"
	"os"
	"os/exec"
	"path/filepath"
	"strings"
	"time"
)

func main() {
	var port string = "8080"
	i, s := initName()
	if(i != "") {
		port = i
	}
	if(strings.Trim(s,"") != "") {
		upload.FilePath = s
	}
	app := iris.New()
	app.RegisterView(iris.HTML("/home/views/", ".html"))
	app.Get("/upload", upload.UploadToHtml)
	app.Post("/upload", iris.LimitRequestBodySize(upload.Max_size+1<<20), upload.UploadPost)

	app.Run(iris.Addr(":"+string(port)), iris.WithPostMaxMemory(upload.Max_size))
}


func initName()(string,string) {
	var port = flag.String("p", "8081", "use for start server port")
	var uploadPath = flag.String("ps","/home/upload/", "file upload path")
	flag.Parse()
	fmt.Println(*port)
	fmt.Println(*uploadPath)
	return *port,*uploadPath
}

func getFilePath() string {
	files, _ := exec.LookPath(os.Args[0])
	s, _ := filepath.Abs(files)
	index := strings.LastIndex(s, string(os.PathSeparator))
	i := s[:index]
	//ff, _ := os.Get()
	return i
}

func slienceLearn() {

	slience := []*int{}
	var a int = 1
	var b int = 1
	var c int = 1
	var d int = 1

	slience = append(slience, &a);
	slience = append(slience, &b);
	slience = append(slience, &c);
	slience = append(slience, &d);
	for _, n := range slience {
		fmt.Print(*n)
	}

	/*	newSlience := &slience[1:3]
		fmt.Print(newSlience)
		*slience[1]= 22
		fmt.Print(newSlience)*/

}
func ts() {
	c1 := make(chan string, 1)
	go testField(c1)
	select {
	case res := <-c1:
		fmt.Printf(res)
	case <-time.After(time.Second * 1):
		fmt.Printf("time.out.wang")
	}
	c1 <- "ok"
	close(c1)

	c1 = make(chan string, 1)
	c1 <- "oks"

	fmt.Printf(<-c1)

}

func testField(c1 chan string) {
	time.Sleep(time.Microsecond * 1)
	var i int = 2
	for {
		if (i < 10000000) {
			fmt.Print(":go continue do it")
			time.Sleep(time.Second * 3)
			i++
		}
		if (i == 10000001) {
			c1 <- "time out"
		}
	}
}
