package com.gupao.vip.mic.dubbo.user.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author fuguofeng
 */
public class StreamCalculationTest {

    public static void main(String[] args) {
        User user1 = new User("1", 9);
        User user2 = new User("2", 4);
        User user3 = new User("f", 11);
        User user4 = new User("ew", 20);
        User user5 = new User("d", 10);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);
        users.stream().filter((t) -> {
            return t.getAge() > 10;
        }).map((t) -> {
            t.setName(t.getName().toUpperCase());
            return t;
        }).sorted((o1, o2) -> {
            return o2.compareTo(o1);
        }).limit(2).forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    static class User implements Comparable{
        private String name;
        private Integer age;

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

}
