package com.ki.basic;

import java.util.stream.Stream;

public class Test05 {
    public static void main(String[] args) {

        // Lambda
        Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        ).filter(s -> s.getGender().equals("male")).forEach(System.out::println);

        // Method Reference
        Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        ).filter(Test05::isMale).forEach(System.out::println);
    }

    static boolean isMale(Student s) {
        return s.getGender().equals("male");
    }
}
