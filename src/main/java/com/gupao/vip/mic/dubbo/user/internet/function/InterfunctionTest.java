package com.gupao.vip.mic.dubbo.user.internet.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfunctionTest {

    Predicate predicate = (t) -> {
        return false;
    };

    Consumer consumer = (t) -> {
    };

    Supplier<String> supplier = () -> {
        return "";
    };

    Function<String, Integer> function = (t) -> {
        return 1024;
    };

    public void f1(Function<String, String> function, String s){
        function.apply(s);
    }


}
