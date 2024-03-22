package ru.stepup.spring.coins.core.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "integrations.executor")
public class ExecutorProperties {
    private RestTemplateProperties client;

    public ExecutorProperties(RestTemplateProperties client) {
        this.client = client;
    }

    public RestTemplateProperties getClient() {
        return client;
    }
}
