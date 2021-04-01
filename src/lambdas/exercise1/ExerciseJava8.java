package lambdas.exercise1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExerciseJava8 {
    public static void main (String args[]){
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
        printConditionally(peopleList, person -> person.getLastName().startsWith("G"));
        System.out.println("----");
        printConditionally(peopleList, person -> person.getFirstName().startsWith("M"));

    }

    public static void displayAllElements(List <Person> list){
        System.out.println(list.stream().collect(Collectors.toList()));
    }

    public static void displayPeopleLastNameStartsG(List <Person> list){
        System.out.println(list.stream().filter(person -> person.getLastName().startsWith("G")).collect(Collectors.toList()));
    }

    public static void printConditionally(List<Person> list, Predicate<Person> predicate){
        for (Person person : list){
            if (predicate.test(person))
                System.out.println(person);
        }
    }
}
