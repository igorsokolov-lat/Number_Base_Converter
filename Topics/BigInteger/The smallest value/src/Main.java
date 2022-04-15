import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        BigInteger numberM = new BigInteger(scanner.nextLine());
        BigInteger factorial = BigInteger.ONE;
        int numberN = 1;
        while (true) {
            factorial = factorial.multiply(BigInteger.valueOf(numberN));
            if (factorial.compareTo(numberM) >= 0) {
                break;
            }
            numberN++;
        }
        System.out.println(numberN);
    }
}