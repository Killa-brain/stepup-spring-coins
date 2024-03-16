package ru.stepup.spring.coins.core.configurations.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "integrations.executor")
public class ExecutorProperties {
    private RestTemplateProperties client;
    private RestTemplateProperties product;

    public RestTemplateProperties getClient() {
        return client;
    }

    public RestTemplateProperties getProduct() {
        return product;
    }

    @ConstructorBinding
    public ExecutorProperties(RestTemplateProperties client, RestTemplateProperties product) {
        this.client = client;
        this.product = product;
    }
}
