package com.kerem.constructionmanagementservice.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            // Örnek olarak, sabit bir token kullanıyorum. Gerçek uygulamada bu token dinamik olarak elde edilmelidir.
            String token = "buraya_geçerli_token_girin";
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}