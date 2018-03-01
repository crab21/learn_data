 Maven依赖的Scope去除部署不需要的jar 包(打包)

　<dependency>

    < groupId>javax.servlet</groupId>

    < artifactId>jsp-api</artifactId>

    < version>2.0</version>

    < scope>provided</scope>

   < /dependency>

　

    compile 默认的scope，表示  dependency 都可以在生命周期中使用。而且，这些dependencies 会传递到依赖的项目中。适用于所有阶段，会随着项目一起发布 
    provided 跟compile相似，但是表明了dependency 由JDK或者容器提供，例如Servlet  AP和一些Java EE APIs。这个scope 只能作用在编译和测试时，同时没有传递性。         
    runtime 表示dependency不作用在编译时，但会作用在运行和测试时，如JDBC驱动，适用运行和测试阶段。 
    test 表示dependency作用在测试时，不作用在运行时。  只在测试时使用，用于编译和运行测试代码。不会随项目发布。 
    system 跟provided  相似，但是在系统中要以外部JAR包的形式提供，maven不会在repository查找它。

配置作用域！
