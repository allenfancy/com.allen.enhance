# Java并发

## 1.线程的生命周期
    新建
    就绪
        当new初一个线程后，调用start()方法后，线程进入了就绪状态,等待CPU的执行。
    运行
    阻塞
        当一个线程获得了CPU的执行之后就进行了运行态，执行的过程中如果遇到如下情况，会继续进入阻塞态:
            1.CPU执行片已经用完，JVM切换到其他线程执行
            2.线程调用sleep()
            3.线程调用了阻塞IO方法，在方法返回结果之前，线程会一直阻塞
            4.线程视图获得被其他线程持有的同步监控器
            5.线程在等待某个通知
            6.程序调用了线程的suspend()将线程挂起（不要使用）
        线程进入阻塞状态后，只有继续阻塞或者再次进入就绪状态：
            1.线程调用的sleep()方法经过了指定时间
            2.线程调用的IO方法返回
            3.线程成功获得同步监控器
            4.线程接收到其他线程发出的通知
            5.被挂起的(suspend)的线程调用管理resume()方法（不要使用）
    死亡
        1.run()或call()正常执行完成，线程正常结束
        2.线程抛出一个未捕获的Exception或者ERROR错误
        3.直接调用线程的stop方法.（不要使用）

## 2. JUC基础



## 3. JUC原子



## 4. JUC锁


## 5. JUC集合


## 6. JUC线程池