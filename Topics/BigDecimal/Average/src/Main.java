import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        BigDecimal numberOne = scanner.nextBigDecimal();
        BigDecimal numberTwo = scanner.nextBigDecimal();
        BigDecimal numberThree = scanner.nextBigDecimal();
        BigDecimal numberOfNumbers = new BigDecimal("3");

        BigDecimal multiplication = numberOne.add(numberTwo.add(numberThree));
        BigDecimal average = multiplication.divide(numberOfNumbers, 0, RoundingMode.DOWN);
        System.out.println(average);
    }
}