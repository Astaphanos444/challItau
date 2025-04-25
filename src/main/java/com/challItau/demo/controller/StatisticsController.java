package com.challItau.demo.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challItau.demo.dto.StatisticsResponse;
import com.challItau.demo.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private TransactionService serv;

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        DoubleSummaryStatistics stats = serv.getStatistics();
        return ResponseEntity.ok().body(new StatisticsResponse(stats));
    }
    
}
