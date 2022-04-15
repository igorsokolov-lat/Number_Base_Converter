import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double firstNumber = scanner.nextDouble();
        double secondNumber = scanner.nextDouble();

        double difference = secondNumber - firstNumber;
        System.out.println(difference);
        // put your code here
    }
}