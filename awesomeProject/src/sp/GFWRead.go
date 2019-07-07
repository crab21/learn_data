package sp

import (
	"bufio"
	"flag"
	"fmt"
	"io"
	"os"
	"strings"
	"time"
)

func OpenRead() {
	fi, _ := os.Open("/Users/wangpeiyuan/Downloads/Quantumult.conf")
	defer fi.Close()
	reader := bufio.NewReader(fi)
	for {
		a, _, c := reader.ReadLine()
		if c==io.EOF {
			break
		}
		se := string(a)
		if(strings.Contains(se,"DIRECT") && strings.Contains(se,"DOMAIN-SUFFIX")) {
			split := strings.Split(se, ",")
			fmt.Println("domain:"+split[1])
		}

		if(strings.Contains(se,"PROXY") && strings.Contains(se,"DOMAIN-SUFFIX")) {
			//split := strings.Split(se, ",")
			//fmt.Println("        \""+split[1]+"\",")
		}

		if(strings.Contains(se,"REJECT") && strings.Contains(se,"DOMAIN-SUFFIX")) {
			//split := strings.Split(se, ",")
			//fmt.Println("domain:"+split[1])
		}
		//fmt.Println(se)
	}

}

func sp()  {
	//openRead()
	/*var p *int
	var s int = 6
	p = &s
	fmt.Println(p)
	fmt.Println(*p)*/

	duration := flag.Duration("period", 1*time.Second, "sleep period")
	flag.Parse()
	fmt.Printf("sleeping for %v........",*duration)
	time.Sleep(*duration)
	fmt.Println()

}


