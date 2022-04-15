import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String[] chars = string.split("");
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + chars[i]);
        }
        // put your code here
    }
}