package com.ki.basic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        // (int a) -> (a & 1) == 0
        // (int a) -> BigInteger.valueOf(a).isProbablePrime(100)
        // (int a, int b, int c) -> a + b + c
        // (int a, int b) -> a - b
        // (int a, int b) -> a * b
        // () -> new Student()
        // () -> ArrayList<Student>()
        // (Student s) -> s.getName()
        // (Student s) -> s.getAge()
        // (Teacher s) -> s.getName()
        // (Student s, Teacher t) -> s.getName() + "は、" + t.getName() + "の生徒です。";

        Face01 test01 = (a) -> (a & 1) == 0;
        System.out.println(test01.check(10));

        Face01 test02 = (a) -> BigInteger.valueOf(a).isProbablePrime(100);
        System.out.println(test02.check(10));

        Face02 test03 = (a,b,c) -> a+b+c;
        System.out.println(test03.check(1,1,1));

        Face03 test04 = (a, b) -> a - b;
        System.out.println(test04.check(3, 1));

        Face03 test05 = (a, b) -> a * b;
        System.out.println(test05.check(3, 1));

        Face04 test06 = () -> new Student("test06", 10, "female");
        Face07<Student> test10 = () -> new Student("test10", 20, "female");
        System.out.println(test06.check());
        System.out.println(test10.check());

        Face05 test07 = () -> new ArrayList<Student>(Arrays.asList(
                new Student("test07", 10, "female"),
                new Student("test0701", 20, "female"),
                new Student("test0702", 30, "male")));
        Face07<ArrayList<Student>> test11 = () -> new ArrayList<Student>(List.of(
                new Student("test07", 10, "female"),
                new Student("test0701", 20, "female"),
                new Student("test0702", 30, "male")
        ));
        System.out.println(test07.check());
        System.out.println(test11.check());

        Face06 test08 = (x) -> x.getName();
        Face08<String> test12 = (x) -> x.getName();
        System.out.println(test08.check(new Student("佐々木", 1, "male")));
        System.out.println(test12.check(new Student("佐々木", 10, "male")));

        Face06 test09 = (x) -> String.valueOf(x.getAge());
        Face08<Integer> test13 = (x) -> x.getAge();
        System.out.println(test09.check(new Student("佐々木", 1, "male")));
        System.out.println(test13.check(new Student("佐々木", 15, "male")));

        Face09<String, Teacher> test14 = (t) -> t.getName();
        System.out.println(test14.check(new Teacher("山田", 19)));
        Face09<Integer, Teacher> test15 = (x) -> x.getAge();
        System.out.println(test15.check(new Teacher("山田", 19)));
        Face09<String, Student> test16 = (x) -> x.getGender();
        System.out.println(test16.check(new Student("佐々木", 15, "male")));



    }

    @FunctionalInterface
    interface Face01 {
        boolean check(int a);
    }

    @FunctionalInterface
    interface Face02 {
        int check(int a, int b, int c);
    }

    @FunctionalInterface
    interface Face03 {
        int check(int a, int b);
    }

    @FunctionalInterface
    interface Face04 {
        Student check();
    }

    @FunctionalInterface
    interface Face05 {
        ArrayList<Student> check();
    }

    @FunctionalInterface
    interface Face06 {
        String check(Student student);
    }

    @FunctionalInterface
    interface Face07<E> {
        E check();
    }

    @FunctionalInterface
    interface Face08<E> {
        E check(Student student);
    }

    @FunctionalInterface
    interface Face09<E,F> {
        E check(F f);
    }
}

class Teacher {
    private String name;
    private int age;
    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

