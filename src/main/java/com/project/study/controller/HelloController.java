package com.project.study.controller;


import com.project.study.dto.ResponseDto;
import com.project.study.service.NumberSelectorService;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class HelloController {

    @PostMapping("/hello")
    @Description(value = "Returns greeting in console")
    public ResponseDto getHelloWorld() {
        return new ResponseDto();
    }

    @PostMapping("/hello-new")
    @Description(value = "Returns greeting in console using given name")
    public ResponseDto getHello(@RequestBody String name) {
        return new ResponseDto(name);
    }

    @GetMapping("/get-odd-numbers")
    @Description(value = "Returns odd numbers from provided list")
    public List<Integer> getOddNumbers(@RequestBody List<Integer> listOfNumbers) {
        NumberSelectorService numberSelectorService = NumberSelectorService.getInstance();
        return numberSelectorService.getOdd(listOfNumbers);
    }

    @GetMapping("/get-even-numbers")
    @Description(value = "Returns even numbers from provided list")
    public List<Integer> getEvenNumbers(@RequestBody List<Integer> listOfNumbers) {
        NumberSelectorService numberSelectorService = NumberSelectorService.getInstance();
        return numberSelectorService.getEven(listOfNumbers);
    }

    @GetMapping("/rep-number")
    @Description(value = "Finds repeating number in list")
    public int findRepeatingNumber(@RequestBody List<Integer> listOfNumbers) {
        NumberSelectorService numberSelectorService = NumberSelectorService.getInstance();
        return numberSelectorService.findRepeatingNumber(listOfNumbers);
    }

    @GetMapping("/unique-number")
    @Description(value = "Finds repeating number in list")
    public List<Integer> findUniqueNumber(@RequestBody List<Integer> listOfNumbers) {
        NumberSelectorService numberSelectorService = NumberSelectorService.getInstance();
        return numberSelectorService.findUniqueNumber(listOfNumbers);
    }

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .uri(new URI("http://postman.com/get"))
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    logger.info("Status {}", response.statusCode())


}


