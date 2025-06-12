package com.ysg.rag_release_helper.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ysg.rag_release_helper.web.dto.LangchainRequestDto;
import com.ysg.rag_release_helper.web.dto.LangserveResponseDto;
import com.ysg.rag_release_helper.web.util.WebClientUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LangchainService {

    private final WebClientUtil webclientUtil;
    
    @Value("${server.llm.url}")
    private String llmServerUrl;

    public LangserveResponseDto.Response requestLLM(LangchainRequestDto.LangchainRequest langchainReq) {

        return webclientUtil.post(llmServerUrl + "/chat/invoke", langchainReq, LangserveResponseDto.Response.class);
    }
}