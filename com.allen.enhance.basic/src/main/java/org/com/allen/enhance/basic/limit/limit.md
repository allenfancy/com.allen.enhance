### 限流算法

#### 1.令牌通算法
> 令牌桶是一个存放固定容量令牌的桶，按照固定速率往桶里添加令牌，填满了就丢弃令牌，请求是否被处理要看桶中令牌是否足够，当令牌数减为零时则拒绝新的请求。令牌桶允许一定程度突发流量，只要有令牌就可以处理，支持一次拿多个令牌。令牌桶中装的是令牌。

#### 2.漏桶限流
>漏桶一个固定容量的漏桶，按照固定常量速率流出请求，流入请求速率任意，当流入的请求数累积到漏桶容量时，则新流入的请求被拒绝。
漏桶可以看做是一个具有固定容量、固定流出速率的队列，漏桶限制的是请求的流出速率。漏桶中装的是请求。

#### 3.计数器限流
 >有时我们还会使用计数器来进行限流，主要用来限制一定时间内的总并发数，比如数据库连接池、线程池、秒杀的并发数；计数器限流只要一定时间内的总请求数超过设定的阀值则进行限流，是一种简单粗暴的总数量限流，而不是平均速率限流。