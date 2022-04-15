import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();

        boolean condition = false;
        if (string.toCharArray().length == 1) {
            condition = true;
        } else {
            for (int i = 1; i < string.toCharArray().length; i++) {
                if (string.toCharArray()[i - 1] + 1 == string.toCharArray()[i]) {
                    condition = true;
                } else {
                    condition = false;
                    break;
                }
            }
        }
        System.out.println(condition);
        // put your code here
    }
}