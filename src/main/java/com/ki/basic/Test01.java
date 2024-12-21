package com.ki.basic;

public class Test01 {

    // 通常の関数
    static int add1(int a, int b) {
        return a + b;
    }

    int add3(int a, int b) {
        return a + b;
    }

    // オブジェクト化した関数
    interface Lambda {
        int calculate(int a, int b);
    }

    static Lambda add2 = (a, b) -> a + b;

    public static void main(String[] args) {

        // 通常関数の利用方法1
        int result1 = Test01.add1(1, 2);
        System.out.println(result1);

        // 通常関数の利用方法2
        Test01 obj1 = new Test01();
        int result3 = obj1.add3(1, 2);
        System.out.println(result3);

        // オブジェクト化した関数の利用方法
        int result2 = add2.calculate(1, 2);
        System.out.println(result2);
    }



}
