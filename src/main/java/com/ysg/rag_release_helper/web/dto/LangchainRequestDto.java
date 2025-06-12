package com.ysg.rag_release_helper.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class LangchainRequestDto {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class Question {
        private String question;
        private int use_rag;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class LangchainRequest{
        private Question input;
    }
}
