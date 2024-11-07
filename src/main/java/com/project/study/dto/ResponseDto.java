package com.project.study.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResponseDto {

    public String name;

    public ResponseDto(String name) {
        this.name = name;
    }
}
