package com.ysg.rag_release_helper;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

// 통신을 위한 WebClient 설정 클래스
@Configuration
public class WebClientConfig {
    
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory();

    HttpClient httpClient = HttpClient.create();

    @Bean
    public WebClient webClient() {
        factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY);
        return WebClient.builder()
            .uriBuilderFactory(factory)
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024)) // 2MB
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build(); 
    }

    @Bean
    public ConnectionProvider connectionProvider() {
        return ConnectionProvider.builder("http-pool")
            .maxConnections(100) // connection pool 갯수
            .pendingAcquireTimeout(Duration.ofMillis(0))
            .pendingAcquireMaxCount(-1)
            .maxIdleTime(Duration.ofMillis(1000L))
            .build();
    }   
}