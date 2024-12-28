package com.ki.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Test09 {
    public static void main(String[] args) {
        Stream<String> stream01 = Stream.of("A", "B", "C", "D", "E", "F");

        // .collect(() -> c, (c, x) -> void, ?)
        // 第三引数は、並列処理時のみ実行されるため、並列ではない場合は、nullでなれば何でもいい
        List<String> result01 = stream01.collect(
                () -> new ArrayList<String>(),
                (c, x) -> c.add(x),
                (x1, x2) -> {});

        System.out.println(result01); // 出力例: [A, B, C, D, E, F]（並列ではないため、順序守られる）

        Stream<String> stream02 = Stream.of("A", "B", "C", "D", "E", "F");

        // 並列処理で収集
        List<String> result02 = stream02.parallel().collect(
                () -> new ArrayList<>(),                                            // 初期化
                (list, item) -> list.add(item),                // 要素をリストに追加
                (list1, list2) -> list1.addAll(list2) // 部分結果を結合
        );
        System.out.println(result02); // 出力例: [A, B, C, D, E, F]（順序は並列性により変わる可能性あり）

        Stream<String> stream03 = Stream.of("A", "B", "C", "D", "E", "F");

        // 並列処理で収集
        List<String> result03 = stream03.parallel().collect(
                () -> new ArrayList<>(),
                (list, item) -> {
                    try {
                        int delay = new Random().nextInt(3); // 0〜3秒のランダムな遅延
                        TimeUnit.SECONDS.sleep(delay);         // 指定秒数待機
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();    // 割り込みを処理
                    }
                    list.add(item);
                },                // 要素をリストに追加
                (list1, list2) -> list1.addAll(list2) // 部分結果を結合
        );
        System.out.println(result03); // 出力例: [A, B, C, D, E, F]（順序は並列性により変わる可能性あり）
    }
}
