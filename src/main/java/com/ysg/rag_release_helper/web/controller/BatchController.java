package com.ysg.rag_release_helper.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysg.rag_release_helper.web.dto.BatchDto;
import com.ysg.rag_release_helper.web.dto.base.DefaultRes;
import com.ysg.rag_release_helper.web.service.BatchService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/batch") // batch 서버와 통신하는 컨트롤러
public class BatchController {
    
    private final BatchService batchService;

    // DB 데이터 개수 조회
    @GetMapping(path = "/count", produces = "application/json")
    public ResponseEntity<?> getCount() {
        BatchDto.Count count = batchService.getCount();
        return new ResponseEntity<>(DefaultRes.res(200, "DB 데이터 개수 조회 성공", count), HttpStatus.OK);
    }
    
    // DB 데이터 삭제
    @DeleteMapping(path = "/delete", produces = "application/json")
    public ResponseEntity<?> deleteData() {
        BatchDto.Message message = batchService.deleteData();
        return new ResponseEntity<>(DefaultRes.res(200, "DB 데이터 삭제 성공", message), HttpStatus.OK);
    }

    // DB 데이터 미리보기
    @GetMapping(path = "/peek", produces = "application/json")
    public ResponseEntity<?> peekData() {
        BatchDto.DataListDto dataList = batchService.peekData();
        return new ResponseEntity<>(DefaultRes.res(200, "DB 데이터 미리보기 성공", dataList), HttpStatus.OK);
    }

    // DB 데이터 스케줄링
    @PostMapping(path = "/schedule", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> doSchedule() {
        BatchDto.Message message = batchService.doSchedule();
        return new ResponseEntity<>(DefaultRes.res(200, "DB 데이터 스케줄링 성공", message), HttpStatus.OK);
    }

}
