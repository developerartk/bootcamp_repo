package com.project.study.controller;


import com.project.study.dto.ResponseDto;
import com.project.study.model.NumberSelector;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @PostMapping("/hello")
    public ResponseDto getHelloWorld() {
        return new ResponseDto();
    }

    @PostMapping("/helloNew")
    public ResponseDto getHello(@RequestBody String name) {
        ResponseDto responseDto = new ResponseDto(name);
        System.out.println("Name: " + name);
        return responseDto;
    }

    @GetMapping("/getOddNumbers")
    public List<Integer> getOddNumbers(@RequestBody List<Integer> listOfNumbers){
        NumberSelector numberSelector = NumberSelector.getInstance();
        return numberSelector.getOdd(listOfNumbers);
    }

    @GetMapping("/getEvenNumbers")
    public List<Integer> getEvenNumbers(@RequestBody List<Integer> listOfNumbers){
        NumberSelector numberSelector = NumberSelector.getInstance();
        return numberSelector.getEven(listOfNumbers);
    }

}


