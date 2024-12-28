package com.ki.basic;

import java.util.stream.Stream;

public class Test04 {
    public static void main(String[] args) {

        // Lambda
        Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        ).forEach((t) -> {
            System.out.println(t);
        });

        // Method Reference
        Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        ).forEach(System.out::println);

        Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        ).forEach(Test04::MyPrint);
    }

    static void MyPrint(Student s) {
        System.out.println(s);
    }
}
