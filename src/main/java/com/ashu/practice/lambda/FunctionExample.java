package com.ashu.practice.lambda;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;

public class FunctionExample {
    public static void main(String[] args) {
        //BiFunction<Integer,Integer,Integer> function = (x1, x2)-> x1+x2;
        IntBinaryOperator function = Integer::sum;
        System.out.println(function.applyAsInt(2,3));

        BiFunction<Integer,Integer,List<Integer>> functionArray = (x1, x2)-> List.of(x1+x2);
        System.out.println(functionArray.apply(4,5));

        // chaining
        //BiFunction<Integer,Integer,Integer> biFunction = Integer::sum;
        BiFunction<Integer,Integer,Integer> biFunction = Integer::sum;
        Function<Integer,String> func = String::valueOf;
        System.out.println(biFunction.andThen(func).apply(7,8));

        Function<List<List<String>>, List<String>> stringFunction = list -> list.stream()
                .map(element -> String.join("", element))
                .toList();
        System.out.println(stringFunction.apply(List.of(List.of("a","p","p"),List.of("o","r"))));
    }
}
