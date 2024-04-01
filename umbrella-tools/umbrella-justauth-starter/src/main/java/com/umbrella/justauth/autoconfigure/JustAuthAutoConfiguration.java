package com.umbrella.justauth.autoconfigure;

import com.umbrella.justauth.support.AuthRequestFactory;
import me.zhyd.oauth.cache.AuthStateCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import static com.umbrella.justauth.autoconfigure.JustAuthProperties.PREFIX;


@Configuration
@EnableConfigurationProperties(JustAuthProperties.class)
@ConditionalOnProperty(prefix = PREFIX, value = "enabled", havingValue = "true", matchIfMissing = true)
public class JustAuthAutoConfiguration {
    @Bean
    public AuthRequestFactory authRequestFactory(JustAuthProperties properties, AuthStateCache authStateCache) {
        return new AuthRequestFactory(properties, authStateCache);
    }

    @Configuration
    @Import({JustAuthStateCacheConfiguration.Default.class, JustAuthStateCacheConfiguration.Redis.class, JustAuthStateCacheConfiguration.Custom.class})
    protected static class AuthStateCacheAutoConfiguration {

    }
}
