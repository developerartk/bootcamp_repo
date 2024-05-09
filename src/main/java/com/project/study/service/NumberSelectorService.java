package com.project.study.service;

import java.util.List;
import java.util.stream.Collectors;

public class NumberSelectorService {

    private static NumberSelectorService instance;

    private NumberSelectorService() {
    }

    public static NumberSelectorService getInstance() {
        if (instance == null) {
            instance = new NumberSelectorService();
        }
        return instance;
    }

    public List<Integer> getOdd(List<Integer> listOfNumbers) {
        return listOfNumbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    public List<Integer> getEven(List<Integer> listOfNumbers) {
        return listOfNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }
}
