package lambdas;

public class RunnableExample {
    public static void main(String args[]) {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Piesek");
            }
        });
        myThread.run();

        Runnable runnableInterface = () -> System.out.println("message from runnableInterface");
        runnableInterface.run();

        Thread lambdaThread = new Thread(() -> System.out.println("message from lambaThread"));
        lambdaThread.run();
    }
}
