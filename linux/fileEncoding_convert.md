http://blog.csdn.net/ownfire/article/details/8295443




一、运用iconv命令执行编码转换文件内容编码转换
iconv -f 现在的编码 -t 要转换的编码 文件
执行之后只是输出经过转换的文本而已，要保存的话
iconv -f 现在的编码 -t 要转换的编码 文件 -o 目标文件
或者
iconv -f 现在的编码 -t 要转换的编码 文件 > 目标文件

二、更好的傻瓜型命令行工具enca，它不但能智能的识别文件的编码，并且还支持成批转换。
enca -x utf-8 *
以上命令是转换当前目录下的所有文件的编码为utf-8
也可以针对单个文件，另外还有一个参数是指定当前语言
enca -L zh_CN -x utf-8 文件

三、文件名编码转换
由于如今用linux,原来在windows里的文件都是用GBK编码的。所以copy到linux下是乱码，文件内容能够用iconv来转 换可是好多中文的文件名仍旧乱码，找到个能够转换文件名编码的命令，就是convmv。
convmv命令细致参数
比如
convmv -f GBK -t UTF-8 *.mp3
不过这个命令不会直正的转换，你能够看到转换前后的比拟。假设要直正的转换要加上参数 –notest
convmv -f GBK -t UTF-8 –notest *.mp3
-f 参数是指出转换前的编码，-t 是转换后的编码。这个千万不要弄错了。不然能够仍旧乱码哦。尚有一个参数很有用。就是 -r 这个表示递归转换现在目录下的一切子目录。

四、目录下所有文件递归转换
find default -type d -exec mkdir -p utf/{} \;
find default -type f -exec iconv -f GBK -t UTF-8 {} -o utf/{} \;
这两行命令将default目录下的文件由GBK编码转换为UTF-8编码，目录结构不变，转码后的文件保存在utf/default目录下。
对上面的命令进行解释：
-exec command: 执行命令, 具体介绍见后文. -ok command: 和-exec一样, 除了命令执行需要用户许可. -print: 打印文件名 -ls: 列出文件详细信息
简单地说, -exec或-ok, 将查询到的文件作为参数传递给后面的命令执行, 而参数的位置用{}标识, 即命令中, “{}”替换成find查找出来的文件名, 最后”\;”表示结束符.
