package com.ki.basic;

import java.util.ArrayList;
import java.util.List;

public class Test02 {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("佐藤", 10, "male"),
                new Student("山田", 30, "female"),
                new Student("藤村", 40, "male"),
                new Student("日村", 20, "female")
        );

        // 通常の関数利用
        // 男性の生徒取得
        List<Student> maleStudents = filter01(students);
        // 30歳以上の生徒取得
        List<Student> over30Students = filter02(students);
        // 女性の生徒取得
        List<Student> femaleStudents = filter01(students);

        // オブジェクト化した関数利用
        maleStudents = filter04(students, (student -> student.getGender().equals("male")));
        over30Students = filter04(students, (student -> student.getAge() > 30));
        femaleStudents = filter04(students, (student -> student.getGender().equals("female")));

        System.out.println(maleStudents);
        System.out.println(over30Students);
        System.out.println(femaleStudents);
    }

    static List<Student> filter01(List<Student> students) {
        List<Student> maleStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getGender().equals("male")) {
                maleStudents.add(student);
            }
        }
        return maleStudents;
    }

    static List<Student> filter02(List<Student> students) {
        List<Student> over30Students = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getAge() > 30) {
                over30Students.add(student);
            }
        }
        return over30Students;
    }

    static List<Student> filter03(List<Student> students) {
        List<Student> feMaleStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (student.getGender().equals("female")) {
                feMaleStudents.add(student);
            }
        }
        return feMaleStudents;
    }

    // オブジェクト化した関数
    interface Lambda {
        boolean check(Student student);
    }

    static List<Student> filter04(List<Student> students, Lambda lambda) {
        List<Student> subStudents = new ArrayList<Student>();
        for (Student student : students) {
            if (lambda.check(student)) {
                subStudents.add(student);
            }
        }
        return subStudents;
    }
}

class Student {
    String name;
    int age;
    String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // 静的メソッド
    public static boolean isMaleStatic(Student student) {
        return "male".equals(student.getGender());
    }

    // インスタンスメソッド
    public boolean isMale(Student student) {
        return "male".equals(student.getGender());
    }

    // インスタンスメソッド (特定オブジェクトで使用)
    public boolean isFemale(Student student) {
        return "female".equals(student.getGender());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
