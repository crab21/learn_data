package upload

import (
	"crypto/md5"
	"fmt"
	"github.com/kataras/iris"
	"io"
	"os"
	"strconv"
	"time"
)

//文件大小
const Max_size = 500 << 20

var FilePath = "/Users/wangpeiyuan/go/src/"

func UploadToHtml(ctx iris.Context) {
	now := time.Now().Unix()
	h := md5.New()
	io.WriteString(h, strconv.FormatInt(now, 10))
	token := fmt.Sprintf("%x", h.Sum(nil))
	ctx.View("upload_form.html", token)
}
func UploadPost(ctx iris.Context) {
	// Get the file from the request.
	file, info, err := ctx.FormFile("uploadfile")
	if err != nil {
		ctx.StatusCode(iris.StatusInternalServerError)
		ctx.HTML("Error while uploading: <b>" + err.Error() + "</b>")
		return
	}
	defer file.Close()
	fname := info.Filename
	//创建一个具有相同名称的文件
	//假设你有一个名为'uploads'的文件夹
	out, err := os.OpenFile(FilePath+fname,
		os.O_WRONLY|os.O_CREATE, 0666)
	if err != nil {
		ctx.StatusCode(iris.StatusInternalServerError)
		ctx.HTML("Error while uploading: <b>" + err.Error() + "</b>")
		return
	}
	defer out.Close()
	io.Copy(out, file)
}
