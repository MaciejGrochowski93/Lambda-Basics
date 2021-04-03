package part3;

import lambdas.part1.Person;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {
    public static void main(String args[]) {
        List<Person> peopleList = Arrays.asList(
                new Person("Pupek", "Pupowski", 3),
                new Person("Gapcio", "Gapciowski", 43),
                new Person("Gąska", "Gąsiowska", 33),
                new Person("Lanosek", "Lanoskowski", 21),
                new Person("Misiek", "Miśkowski", 4),
                new Person("Alf", "Alfowski", 8)
        );
        peopleList.stream()
                .filter(p -> p.getAge() < 10)
                .forEach(System.out::println);
//        .forEach(p -> System.out.println(p));

        peopleList.stream()
                .filter(p -> p.getFirstName().startsWith("A"))
                .count();

    }
}