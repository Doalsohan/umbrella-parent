package com.umbrella.demo.config;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> LOCAL_DATASOURCE = ThreadLocal.withInitial(DataSourceKey.MASTER_DATASOURCE::name);

    public static void setDataSourceKey(DataSourceKey key) {
        LOCAL_DATASOURCE.set(key.name());
    }

    public static String getDataSourceKey() {
        return LOCAL_DATASOURCE.get();
    }

    public static void clearDataSourceKey() {
        LOCAL_DATASOURCE.remove();
    }
}
