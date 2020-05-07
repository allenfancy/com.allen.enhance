## JMX 概念
### 1. JMX规范定义五种MBean
    标准的MBeans
        局限：操作的方法和参数以及返回值的类型 只能是基本的类型；比如Strin、int、long等
        优势：各个Mbean完全没有引用依赖，各service松耦合.
    动态的MBeans
    Open MBeans
    Model MBeans
    MXBeans