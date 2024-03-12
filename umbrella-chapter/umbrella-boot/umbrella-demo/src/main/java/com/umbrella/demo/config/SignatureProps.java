package com.umbrella.demo.config;

import cn.hutool.crypto.asymmetric.SignAlgorithm;
import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConditionalOnProperty(value = "secure.signature.enable",havingValue = "true")
@ConfigurationProperties("secure.signature")
public class SignatureProps {
    private Boolean enable;
    private Map<String,KeyPairProps> keyPair;

    @Data
    public static class KeyPairProps {
        private SignAlgorithm algorithm;
        private String pubKeyPath;
        private String pubKey;
        private String priKeyPath;
        private String priKey;

    }
}
