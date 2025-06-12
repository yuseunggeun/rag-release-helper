package com.ysg.rag_release_helper.web.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class BatchDto {
    
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Count{
        private int count;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Message {
        private String message;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    public static class Metadata {
        private String number;
        private String type;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class DataDto {
        private String id;
        private String document;
        private Metadata metadata;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class DataListDto {
        private List<DataDto> data;
    }
}
