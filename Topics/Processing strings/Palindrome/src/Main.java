import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        String[] chars = word.split("");
        String temp;
        int j = chars.length - 1;
        for (int i = 0; i < chars.length / 2; i++) {
            temp = chars[j];
            chars[j] = chars[i];
            chars[i] = temp;
            j--;
        }
        String newWord = String.join("", chars);
        if (word.equals(newWord)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        // put your code here
    }
}