package java_8;

interface Operation {
    int apply(int a, int b);
}

public class LambdaExpressions2 {

    static int operate(Operation op, int a, int b) {
        return op.apply(a, b);
    }

    public static void main(String[] args) {
        Operation add = (a, b) -> a + b; // Lambda expressions with multiple parameters
        Operation sub = (a, b) -> a - b; // Implement Operation interface

        System.out.println(operate(add, 10, 20));
        System.out.println(operate(sub, 30, 20));
    }

}
