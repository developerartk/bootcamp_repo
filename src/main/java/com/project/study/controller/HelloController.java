package com.project.study.controller;


import com.project.study.dto.ResponseDto;
import com.project.study.service.NumberSelectorService;
import jdk.jfr.Description;
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
        return new ResponseDto(name);
    }

    @GetMapping("/getOddNumbers")
    @Description(value = "Returns odd numbers from provided list")
    public List<Integer> getOddNumbers(@RequestBody List<Integer> listOfNumbers) {
        NumberSelectorService numberSelectorService = NumberSelectorService.getInstance();
        return numberSelectorService.getOdd(listOfNumbers);
    }

    @GetMapping("/getEvenNumbers")
    @Description(value = "Returns even numbers from provided list")
    public List<Integer> getEvenNumbers(@RequestBody List<Integer> listOfNumbers) {
        NumberSelectorService numberSelectorService = NumberSelectorService.getInstance();
        return numberSelectorService.getEven(listOfNumbers);
    }
}


