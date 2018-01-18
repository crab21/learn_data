JAVA_HOME=/home/k/java/jdk1.8.0_101
PATH=$JAVA_HOME/bin:$PATH
CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export JAVA_HOME
export PATH
export CLASSPATH







这两天我的开发机重启了好几次，现每次重启后我的tomcat总是没有启动。
检查Java路径，配置正确，后来拿普通账号启动tomcat时报如下的错：
1
	Neither the JAVA_HOME nor the JRE_HOME environment variable is defined
2
	At least one of these environment variable is needed to run this program

 
原来是我使用的jdk不是通过yum安装的，是我从官网直接下载的，虽然我修改了java_home，但不太智能的tomcat仍然没有自动识别出java_home路径。

解决方法：
编辑文件 /usr/local/tomcat/bin/catalina.sh (根据你自己的jdk路径进行修改) 在文件的正文开头，即正式代码前，大概在99行添加如下代码
1
	export JAVA_HOME=/usr/local/jdk
2
	export JRE_HOME=/usr/local/jdk/jre

修改后大概是下面的样子
view source
01
	# $Id: catalina.sh 1202062 2011-11-15 06:50:02Z mturk $
02
	# -----------------------------------------------------------------------------
03
	 
04
	export JAVA_HOME=/usr/local/jdk
05
	export JRE_HOME=/usr/local/jdk/jre
06
	 
07
	# OS specific support.  $var _must_ be set to either true or false.
08
	cygwin=false
09
	darwin=false
10
	os400=false
11
	case "`uname`" in
12
	CYGWIN*) cygwin=true;;
13
	Darwin*) darwin=true;;
14
	OS400*) os400=true;;
15
	esac .....................



#多台tomcat部署在同一服务器下面：
		1.修改启动端口和关闭端口
			开server.xml文件，修改下面两个地方：
（1）<Server port="8006" shutdown="SHUTDOWN">
修改这个port=”8006”，原来默认的为：8005，使得它的关闭端口和另一个关闭端口不发生冲突。
（2）<Connector port="8081" maxHttpHeaderSize="8192"
               maxThreads="150" minSpareThreads="25" maxSpareThreads="75"
               enableLookups="false" redirectPort="8443" acceptCount="100"
               connectionTimeout="20000" disableUploadTimeout="true" />
修改port=”8081”，原来默认的为“8080”，使得它的连接端口和另一个不冲突。
（3）<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />
修改这个port=”8010”，原来默认的为：8009，AJP 1.3 Connector定义的地方。
