package com.ysg.rag_release_helper.web.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ysg.rag_release_helper.web.dto.BatchDto;
import com.ysg.rag_release_helper.web.dto.BatchDto.Message;
import com.ysg.rag_release_helper.web.util.WebClientUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BatchService {
    
    private final WebClientUtil webClientUtil;

    @Value("${server.batch.url}")
    private String batchServerUrl;

    public BatchDto.Count getCount() {
        return webClientUtil.get(batchServerUrl + "/count", BatchDto.Count.class);
    }

    public BatchDto.Message deleteData() {
        return webClientUtil.delete(batchServerUrl + "/delete_all", BatchDto.Message.class);
    }

    public BatchDto.DataListDto peekData() {
        return webClientUtil.get(batchServerUrl + "/peek", BatchDto.DataListDto.class);
    }

    public Message doSchedule() {
        return webClientUtil.post(batchServerUrl + "/schedule", BatchDto.Message.class);
    }
}
