package lambdas.part1;

public class TypeInferenceExample {
    public static void main(String args[]) {
        StringLengthLambda myLambda = n -> n.length();
        System.out.println(myLambda.getLength("testing"));
        printLambda(L -> L.length());
    }

    interface StringLengthLambda{
        int getLength(String name);
    }

    public static void printLambda(StringLengthLambda L){
        System.out.println(L.getLength("Lambda Basics"));
    }
}
