package com.project.study.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < listOfNumbers.size(); i++) {
            if (listOfNumbers.get(i) % 2 != 0) {
                oddNumbers.add(listOfNumbers.get(i));
            }
        }
        return oddNumbers;
        //return listOfNumbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    public List<Integer> getEven(List<Integer> listOfNumbers) {
        return listOfNumbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public int findRepeatingNumber(List<Integer> listOfNumbers) {
        Collections.sort(listOfNumbers);

        for (int i = 0; i < listOfNumbers.size() - 1; i++) {
            if (listOfNumbers.get(i) == listOfNumbers.get(i + 1)) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<>(List.of(1,5,3,5,3,1,9,7,9,7,20));

        System.out.println(NumberSelectorService.getInstance().findUniqueNumberExtra(listOfNumbers));

    }
    public Integer findUniqueNumberExtra(List<Integer> listOfNumbers) {
        Collections.sort(listOfNumbers);
        System.out.println(listOfNumbers);

        Map<Integer, Integer> numbersMap = new HashMap<>();

        for (int i = 0; i < listOfNumbers.size(); i++) {
            if (!numbersMap.containsKey(listOfNumbers.get(i))) {
                numbersMap.put(listOfNumbers.get(i), 1);
            } else {
                numbersMap.put(listOfNumbers.get(i), numbersMap.get(listOfNumbers.get(i) + 1));
            }
        }
    }

    public List<Integer> findUniqueNumber(List<Integer> listOfNumbers) {
        List<Integer> uniqueValues = new ArrayList<>();
        Collections.sort(listOfNumbers);

        for (int i = 0; i < listOfNumbers.size() - 1; i++) {
            if (i > 0) {
                if (listOfNumbers.get(i) != listOfNumbers.get(i + 1)) {
                    if (listOfNumbers.get(i) != listOfNumbers.get(i - 1)) {
                        System.out.println(listOfNumbers.get(i));
                        uniqueValues.add(listOfNumbers.get(i));
                    }
                }
            }
        }
        return uniqueValues;
    }
}
