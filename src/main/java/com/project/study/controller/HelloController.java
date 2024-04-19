package com.project.study.controller;


import com.project.study.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private ResponseDto responseDto;

    public HelloController(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    @GetMapping("/hello")
    public ResponseDto getHelloWorld() {
        return responseDto;
    }

}
