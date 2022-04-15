import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();

        List<String> companyNamesList = List.of(sequence.split(" "));
        System.out.println(companyNamesList);
    }
}