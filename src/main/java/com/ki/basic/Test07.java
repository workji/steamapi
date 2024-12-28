package com.ki.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test07 {
    public static void main(String[] args) {

        // create stream form collection
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        Stream<String> streamFromList = list.stream();
        streamFromList.forEach(System.out::println);

        // create stream form array
        String[] array = {"dog", "cat", "bird"};
        Stream<String> streamFromArray = Arrays.stream(array);
        streamFromArray.forEach(System.out::println);

        // create stream form object
        Stream<String> streamFromObjects = Stream.of("one", "two", "three");
        streamFromObjects.forEach(System.out::println);

        // create random stream
        Stream<Double> randomNumbers = Stream.generate(Math::random).limit(5);
        randomNumbers.forEach(System.out::println);

        Stream<Integer> iterativeStream = Stream.iterate(1, n -> n + 2).limit(5);
        iterativeStream.forEach(System.out::println);

        // steam operation
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);
        numbers.filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        Stream<String> names = Stream.of("Alice", "Bob", "Charlie");
        names.map(String::toUpperCase)
                .forEach(System.out::println);

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("cat", "dog"),
                Arrays.asList("elephant")
        );

        nestedList.stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        // close stream
        Stream<String> names01 = Stream.of("Alice", "Bob", "Charlie");
        List<String> nameList = names01.collect(Collectors.toList());
        System.out.println(nameList);

        Stream<Integer> numbers01 = Stream.of(1, 2, 3, 4, 5);
        int sum = numbers01.reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // all in one
        List<String> sentences = Arrays.asList(
                "Java is powerful",
                "Streams are fun",
                "FlatMap is useful"
        );

        List<String> words = sentences.stream()
                .map(String::toLowerCase)
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> word.length() > 2)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(words);
    }
}
