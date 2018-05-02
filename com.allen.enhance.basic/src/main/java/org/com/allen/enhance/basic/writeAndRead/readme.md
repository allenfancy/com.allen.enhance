###  Spring + mybatis 四种读写分离方案

#### 1.基于Mybatis配置文件创建读写分离俩个DataSource，每个SqlSessionFactroyBean对象的mapperLocations属性指定俩个读写数据源的配置文件。
>1.1 优点：实现简单
>1.2 缺点：维护麻烦，需要对原有的XML文件进行重新修改，不支持多读，不易扩展

#### 2.通过Spring AOP在业务层实现读写分离，在DAO层调用前定义切面，利用Spring的AbstractRoutingDataSource解决多数据源的问题，实现动态选择数据源.
>1.1 优点：通过注解的方式在DAO每个方法上配置数据源，原有代码改动少，容易扩展，支持多读
>1.2 缺点：需要在DAO每个方法上配置注解，人工管理，容易出错


#### 3.
