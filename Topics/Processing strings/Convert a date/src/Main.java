import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        String[] dates = date.split("-");
        System.out.print(dates[1] + "/" + dates[2] + "/" + dates[0]);
        // put your code here
    }
}