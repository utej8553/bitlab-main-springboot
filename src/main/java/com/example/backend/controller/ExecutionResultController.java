package com.example.backend.controller;

import com.example.backend.dto.ExecutionResultRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/result")
@Slf4j
public class ExecutionResultController {

    @PostMapping
    public void receiveResult(@RequestBody ExecutionResultRequest request) {

        log.info("Job result received: {}", request.getJobId());
        log.info("Logs:\n{}", request.getLogs());

        // later we will store this in DB
    }
}
