
package com.umbrella.justauth.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import me.zhyd.oauth.config.AuthConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

import static com.umbrella.justauth.autoconfigure.JustAuthProperties.PREFIX;

/**
 * <p>
 * JustAuth自动装配配置类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-07-22 10:59
 */
@Getter
@Setter
@ConfigurationProperties(prefix = PREFIX)
public class JustAuthProperties {
    public static final String PREFIX = "justauth";
    /**
     * 是否启用 JustAuth
     */
    private boolean enabled;

    /**
     * JustAuth 默认配置
     */
    private Map<String, AuthConfig> type = new HashMap<>();


    /**
     * http 相关的配置，可设置请求超时时间和代理配置
     */
    private JustAuthHttpConfig httpConfig;

    /**
     * JustAuth 自定义配置
     */
    @NestedConfigurationProperty
    private ExtendProperties extend;

    /**
     * 缓存配置类
     */
    @NestedConfigurationProperty
    private CacheProperties cache = new CacheProperties();

    @Getter
    @Setter
    public static class JustAuthProxyConfig {
        private String type = Proxy.Type.HTTP.name();
        private String hostname;
        private int port;
    }

    @Getter
    @Setter
    public static class JustAuthHttpConfig {
        private int timeout;
        private Map<String, JustAuthProxyConfig> proxy;
    }

}
