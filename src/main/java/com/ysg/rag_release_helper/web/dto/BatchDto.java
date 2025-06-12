package com.ysg.rag_release_helper.web.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// Batch 서버의 응답을 처리하기 위한 DTO 클래스
public class BatchDto {
    
    @Data
    public static class Count{
        private int count;
    }

    @Data
    public static class Message {
        private String message;
    }


    @Data
    public static class Metadata {
        private String number;
        private String type;
    }

    @Data
    public static class DataDto {
        private String id;
        private String document;
        private Metadata metadata;
    }

    @Data
    public static class DataListDto {
        private List<DataDto> data;
    }
}
