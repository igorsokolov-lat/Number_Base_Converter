import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal startingAmount = new BigDecimal(scanner.nextLine());
        BigDecimal interestRate = new BigDecimal(scanner.nextLine());
        int years = scanner.nextInt();

        BigDecimal percent = BigDecimal.ONE.add(interestRate.divide(BigDecimal.valueOf(100)));
        BigDecimal finalAmount = startingAmount.multiply(percent.pow(years));
        System.out.println("Amount of money in the account: " + finalAmount.setScale(2, RoundingMode.CEILING));
        // write your code here
    }
}