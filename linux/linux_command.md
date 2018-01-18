me -a # 查看内核/操作系统/CPU信息 
# head -n 1 /etc/issue # 查看操作系统版本 
# cat /proc/cpuinfo # 查看CPU信息
# hostname # 查看计算机名 
# lspci -tv # 列出所有PCI设备 
# lsusb -tv # 列出所有USB设备 
# lsmod # 列出加载的内核模块 
# env # 查看环境变量 资源
# free -m # 查看内存使用量和交换区使用量
# df -h # 查看各分区使用情况 
# du -sh <目录名> # 查看指定目录的大小
# grep MemTotal /proc/meminfo # 查看内存总量
# grep MemFree /proc/meminfo # 查看空闲内存量 
# uptime # 查看系统运行时间、用户数、负载
# cat /proc/loadavg # 查看系统负载 磁盘和分区 
# mount | column -t # 查看挂接的分区状态 
# fdisk -l # 查看所有分区 
# swapon -s # 查看所有交换分区 
# hdparm -i /dev/hda # 查看磁盘参数(仅适用于IDE设备) 
# dmesg | grep IDE # 查看启动时IDE设备检测状况

 

网络

# ifconfig # 查看所有网络接口的属性 
# iptables -L # 查看防火墙设置 
route -n # 查看路由表 
# netstat -lntp # 查看所有监听端口 
# netstat -antp # 查看所有已经建立的连接 
# netstat -s # 查看网络统计信息 

进程

# ps -ef # 查看所有进程 
# top # 实时显示进程状态


用户

# w # 查看活动用户
# id <用户名> # 查看指定用户信息 
# last # 查看用户登录日志 
# cut -d: -f1 /etc/passwd # 查看系统所有用户
# cut -d: -f1 /etc/group # 查看系统所有组 
# crontab -l # 查看当前用户的计划任务 服务
# chkconfig --list # 列出所有系统服务 
# chkconfig --list | grep on # 列出所有启动的系统服务



tar--->>>
	gip-->>
		tar -czf all.tar.gz *.jpg 将所有的.jpg文件打包成tar包all.tar.gz
		tar -xzf all.tar.gz  解压all.tar.gz
	bzip2-->>
		tar -cjf all.tar.bz2 *.jpg 将所有的.jpg文件压缩成all.tar.bz2
		tar -xjf all.tar.bz2 解压
rar--->>>
	rar x ×××.rar 解压此文件到×××文件夹
zip---->>>
	zip all.zip *.jpg 将所有的jpg文件压缩成zip包
	uzip all.zip -d /wang将all.zip解压到wang文件夹下面


 
查看后台挂起的进程
	ps -ef|grep rm
chmod权限控制：
	0：无
	4：读
	2：写
	1：执行
	
	-rwx-r-r
	属主：读/写/执行
	同组：读
	其他文件：读

chown:
	更改属主
	例如：
		wang.sh  crab--->li用户
		chown -R li /文件
		
 
查看进程日志的:
jstack -l 端口号 > ***.log



查看进程日志的:
jstack -l 端口号 > ***.log
