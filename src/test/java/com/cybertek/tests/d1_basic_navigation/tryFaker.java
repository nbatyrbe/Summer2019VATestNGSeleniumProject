package com.cybertek.tests.d1_basic_navigation;

import com.github.javafaker.Faker;

public class tryFaker {

    public static void main(String[] args) {

        //you create , get dommy data website

        Faker faker = new Faker();

        System.out.println(faker.name().firstName());

    }
}
