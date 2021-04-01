package lambdas;

public class Greeter {

    public void greet(Greeting greeting){
        greeting.perform();
    }

    public static void main (String [] args){

        Greeter greeter = new Greeter();

        Greeting helloGreeting = new HelloGreeting();                           // instancja klasy implementującej Greeting interface
        Greeting lambdaGreeting = () -> System.out.println("Hello, Pupciu");    // wyrażenie lambda typu interface Greeting
        Greeting innerAnnonymousClass = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Kochany Pupek, Kochany Pupek, Kochany Pupek, Pupek jest");
            }
        };
        HelloGreeting gdfg = new HelloGreeting(){
            @Override
            public void perform() {
                System.out.println("hihihi");
            }
        };

        helloGreeting.perform();
        lambdaGreeting.perform();
        innerAnnonymousClass.perform();

        greeter.greet(helloGreeting);
        greeter.greet(innerAnnonymousClass);
        gdfg.perform();
        greeter.greet(lambdaGreeting);
        greeter.greet(() -> System.out.println("hihihi"));
        // chcę użyć wyrażenia lambdy jako coś, co jest klasy Greeting - type inference (wniosek, sugestia?)


        Counter addNumbers = (int c, int d) -> c + d;
        Counter safeDivide = (a, b) -> {
            if (b == 0) return 0;
            return a/b;
        };
        System.out.println(addNumbers.count(2, 5));
        System.out.println(safeDivide.count(6, 3));
        // programowanie obiektowe

        // greetingFunction = () -> System.out.println("Kochany Pupek";

//        doubleTheNumber = public int double (int number){
//            return a*2;
//        }

//        doubleTheNumber = (int number) ->
//            number*2;

        // jeśli to jedna linijka, to można pominąć zarówno klamerkę, jak i return
//        doubleTheNumber = (int number) -> number*2;



        wordCounter countWordLength = (String word) -> word.length();
    }
}
    interface wordCounter{
        int length(String word);
    }
