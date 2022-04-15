import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int firstHalf = 0;
        int secondHalf = 0;
        for (int i = 0; i < number.length() / 2; i++) {
            firstHalf = firstHalf + Character.getNumericValue(number.charAt(i));
        }
        for (int i = number.length() - 1; i >= number.length() / 2; i--) {
            secondHalf = secondHalf + Character.getNumericValue(number.charAt(i));
        }
        if (firstHalf == secondHalf) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
        // put your code here
    }
}