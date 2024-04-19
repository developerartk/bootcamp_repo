package com.project.study.dto;


import org.springframework.stereotype.Component;

@Component
public class ResponseDto {
    private String greeting = "Hello, World!";
    private Long responseId = 1L;


    public Long responseNr = responseId;
    public String message = greeting;
}
