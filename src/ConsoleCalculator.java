import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleCalculator {

    //  ➕ Addition
    public static double add(double a, double b){
        return a + b;
    }

    // ➖ Subtraction
    public static double subtract(double a, double b){
        return a - b;
    }

    // ✖️ Multiplication
    public static double multiply(double a, double b){
        return a * b;
    }

    // ➗ Division
    public static double divide(double a, double b){
        if(b == 0) {
            System.out.println("⚠ Error: Cannot divide by zero!");
            return Double.NaN;
        }
        return a / b;
    }

    // % Modulus
    public static double modulus(double a, double b){
        return a % b;
    }

    // Power
    public static double power(double a, double b){
        return Math.pow(a, b);
    }

    // √ Square root
    public static double squareRoot(double a){
        if(a < 0){
            System.out.println("⚠️ Error: Cannot calculate square root of negative number!");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }

    // n! Factorial
    public static long factorial(int n){
        if(n < 0){
            System.out.println("⚠️ Error: Factorial not defined for negative numbers!");
            return -1;
        }
        long fact = 1;
        for(int i = 1; i <= n; i++){
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> history = new ArrayList<>();
        boolean running = true;

        System.out.println("===== 🚀 Java Console Calculator =====");

        while (running){
            // Menu
            System.out.println("\nChoose an Operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("6. Power (x^y)");
            System.out.println("7. Square Root (√x)");
            System.out.println("8. Factorial (n!)");
            System.out.println("9. Show History");
            System.out.println("10. Exit");

            System.out.println("\uD83D\uDC49 Enter your choice: ");
            int choice;

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("⚠️ Invalid input. Please enter a number!");
                sc.next();
                continue;
            }

            double num1, num2 = 0, result = 0;
            String operation = "";

            switch (choice) {
                // Two-input operations
                case 1: case 2: case 3: case 4: case 5: case 6:
                    System.out.println("Enter first number: ");
                    num1 = sc.nextDouble();
                    System.out.println("Enter second number: ");
                    num2 = sc.nextDouble();
                    break;

                // Single-input operations
                case 7:
                    System.out.println("Enter a number: ");
                    num1 = sc.nextDouble();
                    break;

                case 8:
                    System.out.println("Enter an Integer: ");
                    int n = sc.nextInt();
                    long fact = factorial(n);
                    if(fact != -1){
                        System.out.println("Result: "+fact);
                        history.add("Factorial(" + n + ") = " +fact);
                    }
                    continue;

                case 9:
                    System.out.println("History of Operations:");
                    if(history.isEmpty()){
                        System.out.println("No operations performed yet.");
                    } else {
                        for(String h : history){
                            System.out.println(h);
                        }
                    }
                    continue;

                case 10:
                    running = false;
                    System.out.println("Exiting Calculator... Goodbye");
                    continue;

                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            // Perform calculation
            switch (choice){
                case 1: result = add(num1, num2);
                        operation = num1 + " + " +num2;
                        break;

                case 2: result = subtract(num1, num2);
                        operation = num1 + " - " + num2;
                        break;

                case 3: result = multiply(num1, num2);
                        operation = num1 + " * " + num2;
                        break;

                case 4: result = divide(num1, num2);
                        operation = num1 + " / " + num2;
                        break;

                case 5: result = modulus(num1, num2);
                        operation = num1 + " % " + num2;
                        break;

                case 6: result = power(num1, num2);
                        operation = num1 + " ^ " + num2;
                        break;

                case 7: result = squareRoot(num1);
                        operation = "√" + num1;
                        break;
            }

            System.out.println("Result: " +result);
            history.add(operation + " = " + result);
        }

        sc.close();
    }
}
