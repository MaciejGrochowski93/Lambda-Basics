package lambdas.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExerciseJava7 {
    public static void main(String args[]) {
        List<Person> peopleList = Arrays.asList(
                new Person("Pupek", "Pupowski", 3),
                new Person("Gapcio", "Gapciowski", 43),
                new Person("Gąska", "Gąsiowska", 33),
                new Person("Lanosek", "Lanoskowski", 21),
                new Person("Misiek", "Miśkowski", 4),
                new Person("Alf", "Alfowski", 8)
        );

        Collections.sort(peopleList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        printElements(peopleList);

        System.out.println("-----");
        printConditionally(peopleList, person -> true);

        System.out.println("-----");
        printConditionally(peopleList, new Condition() {
            @Override
            public boolean test(Person person) {
                return person.getLastName().startsWith("G");
            }
        });

    }

    public static void printElements(List<Person> list) {
        for (Person person : list) {
            System.out.println(person);
        }
    }

    public static void printConditionally(List<Person> list, Condition condition) {
        for (Person person : list) {
            if (condition.test(person))
                System.out.println(person);
        }
    }

    public static void printElementsLastNameG(List<Person> list) {
        for (Person person : list) {
            if (person.getLastName().startsWith("G"))
                System.out.println(person);
        }
    }

    public interface Condition {
        boolean test(Person person);
    }

}
