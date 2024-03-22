package ru.stepup.spring.coins.core.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "integrations.product")
public class RestTemplateProperties {
    private String url;
    private Duration connectTimeout;
    private Duration readTimeout;

    public String getUrl() {
        return url;
    }

    public Duration getConnectTimeout() {
        return connectTimeout;
    }

    public Duration getReadTimeout() {
        return readTimeout;
    }

    public RestTemplateProperties(String url, Duration connectTimeout, Duration readTimeout) {
        this.url = url;
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }
}
