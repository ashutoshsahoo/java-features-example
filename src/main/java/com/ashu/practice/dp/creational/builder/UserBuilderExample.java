package com.ashu.practice.dp.creational.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserBuilderExample {

    public static void main(String[] args) {
        User user1 = User.builder("ashu", "sahoo")
                .age(30)
                .phone("1234567")
                .address("Fake address 1234")
                .build();

        log.info(user1.toString());

        User user2 = User.builder("Jack", "Reacher")
                .age(40)
                .phone("5655")
                //no address
                .build();

        log.info(user2.toString());

        User user3 = User.builder("Super", "Man")
                //No age
                //No phone
                //no address
                .build();

        log.info(user3.toString());
    }
}
