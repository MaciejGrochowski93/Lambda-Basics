package part3;

import lambdas.part1.ExerciseJava7;
import lambdas.part1.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 { public static void main(String args[]) {
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
    Collections.sort(peopleList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

    System.out.println("-----");

    performConditionally(peopleList, p -> p.getAge() > 3, System.out::println);
                                                                           // p -> System.out.println(p)
    System.out.println("----for int i----");
    for (int i = 0; i < peopleList.size(); i++)
        System.out.println(peopleList.get(i));
    System.out.println("----for in----");
    for (Person p : peopleList)
        System.out.println(p);
    System.out.println("----forEach----");
    peopleList.forEach(System.out::println);
    // peopleList.forEach(p -> System.out.println(p));

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

    public static void performConditionally(List<Person> list, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person person : list) {
            if (predicate.test(person))
                consumer.accept(person);
        }
    }

    public interface Condition {
        boolean test(Person person);
    }

}
