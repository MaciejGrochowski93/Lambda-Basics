package part2;

public class ThisReferenceExample {

    public static void main (String args[]){
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println(i * 2);
                System.out.println(this);
            }

            @Override
            public String toString() {
                return ("I am TheReferenceExample instance");
            }
        });

        thisReferenceExample.doProcess(10, p -> {
            System.out.println(p * 2);
            // System.out.println(this); - nie zadziała, bo lambda odnosi się do metody "wyżej położonej"
        });

        thisReferenceExample.execute();
    }

    public void doProcess(int i, Process p){
        p.process(i);
    }

    public void execute(){
        doProcess(10, i -> System.out.println("Execute method shows: " + i * 5));
        System.out.println(this);
    }
}
