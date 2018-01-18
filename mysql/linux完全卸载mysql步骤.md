
mysql安装：
https://www.cnblogs.com/bigbrotherer/p/7241845.html
http://www.linuxidc.com/Linux/2016-09/134940.htm
centos完全卸载mysql步骤：

1.yum remove mysql....

2.查看是否还有mysql软件：
	rpm -qa|grep mysql 
	-----如果存在的话继续删除
3.查找mysql残留文件
	find / -name mysql
	若存在，则删除
----通过以上步骤，mysql基本完全删除