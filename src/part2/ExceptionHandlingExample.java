package part2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {
    public static void main (String args[]){
        int someNumbers[] = {2, 3, 5, 8};
        int key = 0;

        process(someNumbers, key, (a, b) -> {
            try{
            System.out.println(a / b);
            }
            catch (ArithmeticException e){
                System.err.println("Arithmetic Exception occured!");
                System.out.println("Arithmetic Exception occured!");
            }
        });

        process(someNumbers, key, wrapper((a, b) -> System.out.println(a/b)));

    }

    private static void process(int number[], int key, BiConsumer<Integer, Integer> biConsumer){
        for (int i : number)
            biConsumer.accept(i, key);
    }

    private static BiConsumer<Integer, Integer> wrapper (BiConsumer<Integer, Integer> biConsumer){
        return (a, b) -> {
            try {
                biConsumer.accept(a, b); // wykonaj, co podano do biConsumera - return biConsumer::accept;
            }
            catch (ArithmeticException e){
                System.err.println("Arithmetic Exception in wrapper!");
            }
        };
    }
}
