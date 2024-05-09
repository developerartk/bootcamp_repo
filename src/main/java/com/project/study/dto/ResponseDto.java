package com.project.study.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResponseDto {

    public String name;

    public ResponseDto(String name) {
        this.name = name;
    }
}

// DTO  - ei ole Component,
//*** väljad ei pea olema private
// võiamlikult lihtne klass, ilma setters
// Tühi vaikimisi konstuktor kaob ära, kui on defineeritud teine.
