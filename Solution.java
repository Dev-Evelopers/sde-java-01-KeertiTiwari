import java.util.Scanner;

abstract class Calculator {
    abstract int add(int a, int b);
}

class Adder extends Calculator {
    int add(int a, int b) {
        System.out.println("Adding integers: " + a + " " + b);
        return a + b;
    }
}

class Multiplier {
    int multiply(int a, int b, Calculator calculator) {
        int result = 0;
        boolean negative = false;
        if (b < 0) {
            b = -b;
            negative = true;
        }
        for (int i = 0; i < b; i++) {
            result = calculator.add(result, a);
        }
        return negative ? -result : result;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Adder adder = new Adder();
        Multiplier multiplier = new Multiplier();

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Testing Addition");
        int sum = adder.add(a, b);
        System.out.println("Sum = " + sum);

        System.out.println("Testing Multiplication");
        int product = multiplier.multiply(a, b, adder);
        System.out.println("Product = " + product);
    }
}
