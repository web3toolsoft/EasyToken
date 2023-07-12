package org.web3soft.commons.mybatis.readwrite;

/**
 * @author Tom Deng
 *
 */
public final class DynamicDataSourceHolder {
    private static final ThreadLocal<DataSourceFrom> DATASOURCE_THREAD_LOCAL = new ThreadLocal<>();

    private DynamicDataSourceHolder() {
    }

    public static void putDataSource(final DataSourceFrom dataSource) {
        DynamicDataSourceHolder.DATASOURCE_THREAD_LOCAL.set(dataSource);
    }

    public static DataSourceFrom getDataSource() {
        return DynamicDataSourceHolder.DATASOURCE_THREAD_LOCAL.get();
    }

    public static void clearDataSource() {
        DynamicDataSourceHolder.DATASOURCE_THREAD_LOCAL.remove();
    }

}
