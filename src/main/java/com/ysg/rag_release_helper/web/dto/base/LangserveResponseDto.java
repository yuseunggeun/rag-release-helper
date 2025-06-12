package com.ysg.rag_release_helper.web.dto.base;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;

public class LangserveResponseDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Response {
        private OutputDTO output;
        private MetadataDTO metadata;
    }

    // Getters and Setters

    @Getter
    @Builder
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class OutputDTO {
        private String content;
        private Map<String, Object> additionalKwargs;
        private ResponseMetadataDTO responseMetadata;
        private String type;
        private String name;
        private String id;
        private boolean example;
        private List<Object> toolCalls;
        private List<Object> invalidToolCalls;
        private Object usageMetadata;

        // Getters and Setters

        @Getter
        @Builder
        @AllArgsConstructor
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class ResponseMetadataDTO {
            private TokenUsageDTO tokenUsage;
            private String modelName;
            private String systemFingerprint;
            private String finishReason;
            private Object logprobs;

            // Getters and Setters

            @Getter
            @Builder
            @AllArgsConstructor
            @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
            public static class TokenUsageDTO {
                private int completionTokens;
                private int promptTokens;
                private int totalTokens;

                // Getters and Setters
            }
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class MetadataDTO {
        private String runId;
        private List<Object> feedbackTokens;

        // Getters and Setters
    }
}