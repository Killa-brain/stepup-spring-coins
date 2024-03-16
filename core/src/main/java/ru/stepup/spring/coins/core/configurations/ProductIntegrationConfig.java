package ru.stepup.spring.coins.core.configurations;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.stepup.spring.coins.core.configurations.properties.ExecutorProperties;
import ru.stepup.spring.coins.core.exceptions.RestTemplateResponseErrorHandler;
import ru.stepup.spring.coins.core.integrations.ProductIntegration;
import ru.stepup.spring.coins.core.integrations.ProductIntegrationRestClient;

@Configuration
public class ProductIntegrationConfig {

    @Bean
    public ProductIntegration productIntegration( ExecutorProperties executorProperties,
                                                  RestTemplateResponseErrorHandler restTemplateResponseErrorHandler
    ) {
        var client = RestClient.create(executorProperties.getProduct().getUrl());
        return new ProductIntegrationRestClient(client);
    }
}
