package com.gupao.vip.mic.dubbo.user.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fuguofeng
 */
public class StreamCalculationTest1 {

    public static void main(String[] args) {
        User user1 = new User(11, "jack");
        User user2 = new User(21, "mary");
        User user3 = new User(17, "jame");
        User user4 = new User(12, "martin");
        User user5 = new User(31, "jackson");

        List<User> userList = Arrays.asList(user1, user2, user3, user4, user5);
        List<? extends Object> u = userList.stream().filter(t -> t.getAge() > 10)
                .filter(t -> t.getUserName().startsWith("j"))
                .map(t -> t.setUserName(t.getUserName().toUpperCase()))
                .limit(10)
                .collect(Collectors.toList());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Accessors(chain = true)
    static class User {
        private Integer age;
        private String userName;
    }

}
