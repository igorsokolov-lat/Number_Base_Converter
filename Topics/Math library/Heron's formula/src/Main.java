import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double sideA = scanner.nextInt();
        double sideB = scanner.nextInt();
        double sideC = scanner.nextInt();

        double perimeter = (sideA + sideB + sideC) / 2;

        double squaredArea = perimeter * (perimeter - sideA) * (perimeter - sideB) * (perimeter - sideC);
        double area = Math.sqrt(squaredArea);
        System.out.println(area);
        // put your code here
    }
}