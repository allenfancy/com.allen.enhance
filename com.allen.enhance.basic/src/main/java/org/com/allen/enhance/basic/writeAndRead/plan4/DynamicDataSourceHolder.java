package org.com.allen.enhance.basic.writeAndRead.plan4;

public class DynamicDataSourceHolder {

    private static final ThreadLocal<DynamicDataSourceGlobal> holder =
            new ThreadLocal<DynamicDataSourceGlobal>();

    public static void putDataSource(DynamicDataSourceGlobal dataSource) {
        holder.set(dataSource);
    }

    public static DynamicDataSourceGlobal getDataSource() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }
}
