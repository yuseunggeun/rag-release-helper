package com.ysg.rag_release_helper.web.util;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.ysg.rag_release_helper.WebClientConfig;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WebClientUtil {

    private final WebClientConfig webClientConfig;

    public <T> T get(String url, Class<T> responseDtoClass){
        return webClientConfig.webClient().method(HttpMethod.GET)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseDtoClass)
                .block(); //동기 실행
    }

    public <T, V> T post(String url, V requestDto, Class<T> responseDtoClass){
        return webClientConfig.webClient().method(HttpMethod.POST)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(responseDtoClass)
                .block(); //동기 실행
    }

    public <T, V> T post(String url, Class<T> responseDtoClass){
        return webClientConfig.webClient().method(HttpMethod.POST)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseDtoClass)
                .block(); //동기 실행
    }

    public <T, V> T delete(String url, Class<T> responseDtoClass){
        return webClientConfig.webClient().method(HttpMethod.DELETE)
                .uri(url)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(responseDtoClass)
                .block(); //동기 실행
    }
}