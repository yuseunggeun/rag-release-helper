package com.ysg.rag_release_helper.web.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class DefaultRes<T> {
    private Integer status;
    private String responseMessage;
    private T data;

    public DefaultRes(final Integer status, final String responseMessage) {
        this.status = status;
        this.responseMessage = responseMessage;
        this.data = null;
    }

    public static<T> DefaultRes<T> res(final Integer status, final String responseMessage) {
        return res(status, responseMessage, null);
    }

    public static<T> DefaultRes<T> res(final Integer status, final String responseMessage, final T t) {
        return DefaultRes.<T>builder()
                .data(t)
                .status(status)
                .responseMessage(responseMessage)
                .build();
    }
}