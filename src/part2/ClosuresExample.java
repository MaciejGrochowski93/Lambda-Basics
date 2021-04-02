package part2;

public class ClosuresExample {
    public static void main (String args[]){
        int a = 10;
        int b = 20;     // b to "closure" - wartość jest zamrożona jako finalna do wykorzystania przez klasę
                        // można dodać do metody klasy wewnętrznej, jeśli to jest stała finalna
                        // od Javy 8 jeśli nie podpiszemy inta do metody, to i tak uzna za "effective final"
                        // i będzie kwękać, jeśli spróbujemy zmienić
                        //

        doProcess(a, new Process(){
            @Override
            public void process(int i) {
                System.out.println(i + b);
            }
        });

        doProcess(a, i -> System.out.println(i + b));
    }

    public static void doProcess(int i, Process p){     // metoda jest wykonywana TUTAJ, nie w main
        p.process(i);
    }
}

interface Process{
    void process(int i);
}