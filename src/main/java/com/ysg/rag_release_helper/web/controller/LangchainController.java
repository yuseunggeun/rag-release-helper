package com.ysg.rag_release_helper.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysg.rag_release_helper.web.dto.LangchainRequestDto;
import com.ysg.rag_release_helper.web.dto.base.DefaultRes;
import com.ysg.rag_release_helper.web.dto.base.LangserveResponseDto;
import com.ysg.rag_release_helper.web.service.LangchainService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/langchain") // llm 서버와 통신
public class LangchainController {

    private final LangchainService langchainService;


    @PostMapping(path = "/request", consumes = "application/json")
    public ResponseEntity<?> requestLLM(@RequestBody LangchainRequestDto.LangchainRequest langchainReq) {
        LangserveResponseDto.Response response = langchainService.requestLLM(langchainReq);
        
        if (response == null) {
            return new ResponseEntity<>(DefaultRes.res(500, "LLM 질의응답 실패"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(DefaultRes.res(201, "LLM 질의응답 성공", response), HttpStatus.OK);
    }
    

}
