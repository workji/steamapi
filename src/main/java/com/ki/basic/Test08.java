package com.ki.basic;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test08 {
    public static void main(String[] args) {
        Stream<String> stream01 = Stream.of("apple", "banana", "cherry", "date");

        // Stream を ArrayList に収集
        List<String> list = stream01.collect(Collectors.toList());
        System.out.println("ArrayList: " + list); // [apple, banana, cherry, date]

        Stream<String> stream02 = Stream.of("apple", "banana", "cherry", "date");

        // Stream を Set に収集
        Set<String> set = stream02.collect(Collectors.toSet());
        System.out.println("Set: " + set); // [apple, banana, cherry] （重複は排除される）

        Stream<String> stream03 = Stream.of("apple", "banana", "kiwi");

        // 要素の長さをキー、要素自体を値として Map に収集
        Map<Integer, String> map = stream03.collect(Collectors.toMap(
                String::length, // キー: 要素の長さ
                s -> s          // 値: 要素自体
        ));

        System.out.println("Map: " + map); // {5=apple, 6=banana, 6=cherry}

        Stream<String> stream04 = Stream.of("apple", "banana", "apricot", "orange", "cherry");

        // 長さが同じ場合は「,」で結合する
        Map<Integer, String> map01 = stream04.collect(Collectors.toMap(
                String::length,       // キー: 要素の長さ
                s -> s,               // 値: 要素自体
                (existing, replacement) -> existing + ", " + replacement // マージ関数
        ));

        System.out.println("Map: " + map01); // {5=apple, 6=banana, 7=apricot}

        Stream<String> stream05 = Stream.of("apple", "banana", "cherry");

        // 要素を単純に連結
        String result = stream05.collect(Collectors.joining());
        System.out.println("Joined String: " + result); // applebananacherry

        Stream<String> stream06 = Stream.of("apple", "banana", "cherry");

        // 要素を「, 」で区切って連結
        String result01 = stream06.collect(Collectors.joining(", "));
        System.out.println("Joined String: " + result01); // apple, banana, cherry

        Stream<String> stream07 = Stream.of("apple", "banana", "cherry");

        // 要素を「, 」で区切り、"[ ]" で囲む
        String result02 = stream07.collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined String with Brackets: " + result02); // [apple, banana, cherry]

        Stream<String> stream08 = Stream.of("apple", "banana", "cherry", "orange");

        // 自分の Collector を定義
        StringBuilder result03 = stream08.collect(Collector.of(
                StringBuilder::new,         // 初期生成
                StringBuilder::append,      // 要素を追加
                StringBuilder::append       // 並列処理時の結合
        ));

        System.out.println("StringBuilder: " + result03.toString()); // applebananacherry
    }
}
