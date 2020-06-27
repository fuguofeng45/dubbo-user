package com.gupao.vip.mic.dubbo.user.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamCodeTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        List<Integer> list1 = list.stream().filter((l) -> {
            return l % 2 == 0;
        }).collect(Collectors.toList());
        list1.forEach(System.out::println);

        Function<String, String> function = (f)->{
          return f;
        };
        System.out.println(function.apply("2"));

        Supplier<String> supplier = ()->{
            return "3231";
        };
    }

}
