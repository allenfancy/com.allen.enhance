## AQS and CAS and Synchronized

### 1.CAS 

> CAS 是为了解决多线程并行情况下使用锁造成性能损耗的一种机制,CAS操作包含三个操作数-内存位置(V)，预期原值(A)和新值(B)。
sun.misc.Unsafe类提供了硬件级别的原子操作来实现CAS.
#### 1.1 CAS 典型应用
> atomic包下的类大多数是使用CAS操作来实现的。
#### 1.2 CAS的ABA问题
>> 1.2.1 AtomicStampedReference 对对象带上一个时间戳

### 2.AQS
> AQS(AbstractQueueSynchronizer),AQS是JDK下提供一套基于实现FIFO的等待队列的阻塞锁和相关同步器的一个同步框架。这个歌抽象类被设计为作为一些可用原子int值来表示状态的同步器的基类。


### 3.Synchronized
> 3.1.修饰实例方法，作用于当前实例加锁，进入同步代码钱需要获得当前实例的锁<br>
> 3.2.修饰静态方法，作用当前类对象的枷锁，进入同步代码前需要获得当前类对象的锁<br>
> 3.3.修饰代码块,指定枷锁对象，对给定对象枷锁，进入同步代码库前获得给定对象的锁<br>
> Synchronized的底层语义原理:<br>
>Java虚拟机中的同步(Synchronization)基于进入和退出管理(Monitor)对象实现，无论是显示同步还是隐式同步都是如此。在Java语言中，同步的最多的地方可能是被synchronized修饰的同步方法.同步方法并不是由monitorenter和monitorexit指令来实现同步的，而方法调用指定读取运行时常量池中的ACC_SYNCHRONIZED标志来隐式实现的。
理解Java对象头与Monitor:
> 在JVM中，对象在内存中的布局分为三块区域:对象头，实例数据和对齐填充。如下:<br>
>1. 实例变量:存放类的属性数据信息，包括弗雷的属性信息，如果是数组的实例部分还包括数据的长度，这部分内存按4字节对齐。<br>
>2. 填充数据:由于虚拟机要求对象其实地址必须是8字节的整数倍。填充数据不是必须存在的，仅仅为了字节对齐。<br>
>3. Java头对象：是synchronized的锁对象的基础，结构是Mark word和Class MetaData Address组成，结构说明如下：<br>
>> 3.1 Mark World : 存储对象的hashCode 锁信息或分代年龄或GC标志等信息<br>
>> 3.2 Class MetaData Address: 类型指针指向对象的类元数据，JVM通过这个指针确定该对象时哪个类的实例。<br>
>4. Java虚拟机对synchronized的优化<br>
> 4.1 锁的状态有四种，无锁状态，偏向锁，轻量级锁和重量级锁。随着锁的竞争，锁可以从偏向锁升级到轻量级锁，再升级的重量级锁，但是锁的升级是单向的。<br>
> 4.2 synchronized锁的可重入性<br>