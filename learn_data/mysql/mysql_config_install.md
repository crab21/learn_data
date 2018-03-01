数据库的安装过程及详细解释：
	http://www.centoscn.com/mysql/2014/1211/4290.html
数据库无法远程访问的问题。
	http://www.cnblogs.com/hzhida/archive/2012/08/03/2621547.html
1。 改表法。可能是你的帐号不允许从远程登陆，只能在localhost。这个时候只要在localhost的那台电脑，登入mysql后，更改 "mysql" 数据库里的 "user" 表里的 "host" 项，从"localhost"改称"%"
CODE:mysql -u root -p123
mysql>use mysql;
mysql>update user set host = '%' where user = 'root';
mysql>select host, user from user;
	----------------->>>>>>>>>>>>>推荐使用--------------------->>>>>>>>>>>>>>>>>>
　　2. 授权法。例如，你想kevin使用mypassword从任何主机连接到mysql服务器的话。
CODE:GRANT ALL PRIVILEGES ON *.* TO 'kevin'@'%' IDENTIFIED BY 'mypassword' WITH GRANT OPTION;
　　如果你想允许用户kevin从ip为192.168.101.234的主机连接到mysql服务器，并使用mypassword作为密码
CODE:GRANT ALL PRIVILEGES ON *.* TO 'kevin'@'192.168.101.234' IDENTIFIED BY 'mypassword' WITH GRANT OPTION;
　　3.如果按照上面这样做还不行(一般好像在windows下那样就可以了)那就修改下面这个配置文件吧(我是在linux环境下 大家可以找到自己mysql安装目录下的相应配置文件)
CODE:vi /etc/mysql/my.cnf
　　注释掉
CODE:#bind-address = 127.0.0.1
　　大功告成！！！

然后我采用的是第一种方法，然后在运行完最后一句话后出了个错误ERROR 1062 (23000): Duplicate entry '%-root' for key 'PRIMARY' 
于是又去找解决方案，发现先
mysql> select host from user where user = 'root'; 

+-----------------------+ 
| host | 
+-----------------------+ 
| % | 
| 127.0.0.1 | 
| localhost.localdomain | 
+-----------------------+ 
3 rows in set (0.00 sec) 
host已经有了%这个值，所以直接运行命令： 

mysql>flush privileges; 
果然还行的通，由于对mysql不是很深入的了解，通过php果然可以远程访问了，但是我忽略了一点
这里将host = '%'后，是可以远程访问了，但是我们使用root不能访问本地了
这是由于%的意思就是允许除本机外的所有都可以访问

如果前面已经如上操作了，那么你再在本地访问的时候
#mysql -u root -p
输入密码后会提示

 

  ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: YES) 
  这就很郁闷，本机已经无法登陆了，这时我们需要安全模式进入(个人理解为安全模式)
  首先，将mysql服务停止
  #/etc/init.d/mysql stop   或者  #sudo service mysqld stop
  然后再执行
  # mysqld_safe --user=mysql --skip-grant-tables --skip-networking &
  记住  后面那个  &是需要的
  等出现一些提示后  应该是在starting...之后
  直接输入  mysql 即可进入数据库了  (这里其实也可以是忘记密码后进行修改密码的方法)
  进入后，修改密码的语句为：
  mysql> use mysql;   
  进入数据库修改密码
  mysql> update user set password = PASSWORD('你的新密码') where user='root'
  如果是要解决上面修改了host的方法就是执行
  mysql> update user set host='localhost' where user='root' and host='%'
  将host改回来

  但是改回来岂不是又无法远程访问了？
  其实我们可以新增一个用户，把必要的权限授予于这个用户，且将这个用户的host设为%


  过程中出现的错误要仔细查看，要注意防火墙的状态，可能影响数据库的远端连接。
