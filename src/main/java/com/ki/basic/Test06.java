package com.ki.basic;

import java.util.stream.Stream;

public class Test06 {
    public static void main(String[] args) {
        // 学生データのストリーム作成
        Stream<Student> students = Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        );

        // **静的メソッド引用**：性別が "male" の学生をフィルタリング
        System.out.println("男性の学生 (静的メソッド引用):");
        students
                .filter(Student::isMaleStatic) // 静的メソッド引用
                .forEach(System.out::println);

        // 学生データのストリーム再生成
        students = Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        );

        // **特定オブジェクトのインスタンスメソッド引用**：性別が "female" の学生をフィルタリング
        System.out.println("女性の学生 (特定オブジェクトのインスタンスメソッド引用):");
        Student checker = new Student();
        students
                .filter(checker::isFemale) // 特定オブジェクトのインスタンスメソッド引用
                .forEach(System.out::println);

        // 学生データのストリーム再生成
        students = Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        );

        // **任意オブジェクトのインスタンスメソッド引用**：名前が "佐々木" の学生をフィルタリング
        System.out.println("名前が '佐々木' の学生 (任意オブジェクトのインスタンスメソッド引用):");
        students
                .filter(student -> student.getName().equals("佐々木")) // Lambda式
                .forEach(System.out::println);

        // 学生データのストリーム再生成
        students = Stream.of(
                new Student("佐々木", 18, "female"),
                new Student("山田", 30, "male"),
                new Student("藤村", 41, "female"),
                new Student("武田", 61, "male")
        );

        // **Lambda式**：年齢が 40 未満の学生をフィルタリング
        System.out.println("40歳未満の学生 (Lambda式):");
        students
                .filter(student -> student.getAge() < 40) // Lambda式
                .forEach(System.out::println);
    }
}
