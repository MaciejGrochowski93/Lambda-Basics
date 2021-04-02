package lambdas.part1;

public class HelloGreeting implements Greeting{
    @Override
    public void perform() {
        System.out.println("HelloGreeting class");
    }
}
