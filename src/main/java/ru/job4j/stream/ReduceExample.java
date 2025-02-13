package ru.job4j.stream;

import ru.job4j.stream.mapto.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Optional<Integer> sum = numbers.stream()
                .reduce((left, right) -> left + right);
        System.out.println(sum.get());

        List<String> nums = List.of("Один", "Два", "Три");
        Optional<String> optionalString = nums.stream()
                .reduce((left, right) -> left + ", " + right);
        System.out.println(optionalString.get());

        int twoSum = numbers.stream()
                .reduce(2, (left, right) -> left + right);
        System.out.println(twoSum);

        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        int ageSum = people.stream()
                .reduce(0,
                        (left, right) -> {
                            if (right.getAge() > 25) {
                                return left + right.getAge();
                            } else {
                                return left;
                            }
                        },
                        (left, right) -> left + right
                );
        System.out.println(ageSum);

        int min = people.parallelStream()
                .reduce(
                        0,
                        (left, right) -> left + right.getAge(),
                        Integer::min
                );
        System.out.println(min);
    }

}
