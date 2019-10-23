package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String s = "сапог сарай арбуз болт бокс биржа веревка воз oгурец";

        Map<Character, Set<String>> map = Arrays.stream(s.toLowerCase()
                .split(" "))
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.groupingBy(s1 -> s1.charAt(0), TreeMap::new, Collectors.mapping(Function.identity(), Collectors.toSet())));
        map.entrySet().removeIf(entry -> entry.getValue().size() <= 1);
        System.out.println(map);
    }
}
