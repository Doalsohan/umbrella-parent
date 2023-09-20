package com.umbrella.demo.config;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.MASTER::name);

    public static void setDataSourceKey(DataSourceKey key) {
        CONTEXT_HOLDER.set(key.name());
    }

    public static String getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }
}
