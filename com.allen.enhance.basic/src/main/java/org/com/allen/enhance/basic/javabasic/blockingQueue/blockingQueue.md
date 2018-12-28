## 阻塞队列

### ArrayBlockingQueue
    基于数组的阻塞队列实现，其内部维护一个定长的数组，用于存储队列元素。
    线程阻塞的实现是通过ReentrantLock来完成的，数据的插入与取出共用同一个锁，因此ArrayBlockingQueue并不能实现生产、消费同时进行。
    而且在创建ArrayBlockingQueue时，我们还可以控制对象的内部锁是否采用公平锁，默认采用非公平锁。

### LinkedBlockingQueue
    　基于单向链表的阻塞队列实现，在初始化LinkedBlockingQueue的时候可以指定对立的大小，也可以不指定，
      默认类似一个无限大小的容量（Integer.MAX_VALUE），不指队列容量大小也是会有风险的，一旦数据生产速度大于消费速度，系统内存将有可能被消耗殆尽，因此要谨慎操作。
      另外LinkedBlockingQueue中用于阻塞生产者、消费者的锁是两个（锁分离），因此生产与消费是可以同时进行的。

### PriorityBlockingQueue
    一个支持优先级排序的无界阻塞队列
    
### SynchronousBlockingQueue
    一个不存储原数据的阻塞队列

### DelayQueue 
    使用优先级队列实现的无界阻塞队列