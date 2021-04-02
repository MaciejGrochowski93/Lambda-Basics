package lambdas.part1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciseJava8 {
    public static void main(String args[]) {
        List<Person> peopleList = Arrays.asList(
                new Person("Piesek", "Głaskowski", 3),
                new Person("Kotek", "Ogonowski", 43),
                new Person("Gąska", "Gąskowska", 33),
                new Person("Lanosek", "Lanoskowski", 21),
                new Person("Misiek", "Miśkowski", 4),
                new Person("Alf", "Alfowski", 8)
        );
        displayAllElements(peopleList);
        displayPeopleLastNameStartsG(peopleList);

        Collections.sort(peopleList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

        System.out.println("----");
        printConditionally(peopleList, p -> p.getLastName().startsWith("G"));
        System.out.println("----");
        printConditionally(peopleList, p -> p.getFirstName().startsWith("M"));

        System.out.println("----");
        performConditionally(peopleList, p -> p.getFirstName().startsWith("L"), p -> System.out.println(p));
        performConditionally(peopleList, p -> p.getFirstName().startsWith("L"), p -> System.out.println(p.getFirstName()));

        System.out.println("----");
        performConditionally(peopleList, p -> p.getAge() == 3, p -> System.out.println(p.getFirstName()));

    }

    public static void displayAllElements(List<Person> list) {
        System.out.println(list.stream().collect(Collectors.toList()));
    }

    public static void displayPeopleLastNameStartsG(List<Person> list) {
        System.out.println(list.stream().filter(person -> person.getLastName().startsWith("G")).collect(Collectors.toList()));
    }

    public static void printConditionally(List<Person> list, Predicate<Person> predicate) {
        for (Person person : list) {
            if (predicate.test(person))
                System.out.println(person);
        }
    }

    public static void performConditionally(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person person : list) {
            if (predicate.test(person))
                consumer.accept(person);
        }
    }
}
