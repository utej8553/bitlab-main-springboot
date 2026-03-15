package com.example.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Service
@RequiredArgsConstructor
public class SqsJobService {

    private final SqsClient sqsClient;

    private final String queueUrl =
            "https://sqs.us-east-2.amazonaws.com/160927904719/code-execution-queue";

    public void sendJob(String jobId, String language, String code) {

        String message = String.format("""
        {
            "jobId":"%s",
            "language":"%s",
            "code":"%s"
        }
        """, jobId, language, code.replace("\"", "\\\""));

        SendMessageRequest request = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .build();

        sqsClient.sendMessage(request);
    }
}
