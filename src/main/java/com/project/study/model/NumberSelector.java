package com.project.study.model;

import java.util.List;
import java.util.stream.Collectors;

public class NumberSelector {
    private static NumberSelector instance;

    private NumberSelector() {
    }
    public static NumberSelector getInstance() {
        if (instance == null) {
            instance = new NumberSelector();
        }
        return instance;
    }

    public List<Integer> getOdd(List<Integer> listOfNumbers) {
       return listOfNumbers.stream().filter(n -> n %2 != 0).collect(Collectors.toList());
    }

    public List<Integer> getEven(List<Integer> listOfNumbers) {
        return listOfNumbers.stream().filter(n -> n %2 == 0).collect(Collectors.toList());
    }
}
