package com.ysg.rag_release_helper.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LangchainRequestDto {

    @Data
    public static class Question {
        private String question;
        private int use_rag;
    }

    @Data
    public static class LangchainRequest{
        private Question input;
    }
}
