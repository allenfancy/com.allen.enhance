package org.com.allen.enhance.basic.writeAndRead.plan2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import io.netty.util.internal.ThreadLocalRandom;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private DataSource writeDataSource;

    private List<DataSource> readDataSources;

    private int readDataSourceSize; // 读数据源个数

    private int readDataSourcePollPattern = 0; // 读取数据源方式.0:随机，1:轮询

    private AtomicLong counter = new AtomicLong(0);

    private static final Long MAX_POOL = Long.MAX_VALUE;

    private final Lock lock = new ReentrantLock();

    @Override
    public void afterPropertiesSet() {
        if (this.writeDataSource == null) {
            throw new IllegalArgumentException("Property 'writeDataSource' is required.");
        }
        setDefaultTargetDataSource(writeDataSource);
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DynamicDataSourceGlobal.WRITE.name(), writeDataSource);
        if (this.readDataSources == null || this.readDataSources.size() == 0) {
            readDataSourceSize = 0;
        } else {
            for (int i = 0; i < readDataSources.size(); i++) {
                targetDataSources.put(DynamicDataSourceGlobal.READ.name() + i,
                        readDataSources.get(i));
            }
            readDataSourceSize = readDataSources.size();
        }
        setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        DynamicDataSourceGlobal dynamicDataSourceGlobal = DynamicDataSourceHolder.getDataSource();
        if (dynamicDataSourceGlobal == null
                || dynamicDataSourceGlobal == DynamicDataSourceGlobal.WRITE
                || readDataSourceSize <= 0) {
            return DynamicDataSourceGlobal.WRITE.name();
        }
        int index = 1;
        if (readDataSourcePollPattern == 1) {
            // 轮询方式
            long currValue = counter.incrementAndGet();
            if ((currValue + 1) > MAX_POOL) {
                try {
                    lock.lock();
                    if ((currValue + 1) >= MAX_POOL) {
                        counter.set(0);
                    }
                } finally {
                    lock.unlock();
                }
                index = (int) (currValue % readDataSourceSize);
            } else {
                index = ThreadLocalRandom.current().nextInt(0, readDataSourceSize);
            }
        }
        return dynamicDataSourceGlobal.name() + index;
    }

    public void setWriteDataSource(DataSource writeDataSource) {
        this.writeDataSource = writeDataSource;
    }

    public void setReadDataSources(List<DataSource> readDataSources) {
        this.readDataSources = readDataSources;
    }

    public void setReadDataSourcePollPattern(int readDataSourcePollPattern) {
        this.readDataSourcePollPattern = readDataSourcePollPattern;
    }
}
