import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputNumbers = scanner.nextLine();
        int numberN = scanner.nextInt();

        String[] numbersString = inputNumbers.split(" ");
        int[] numbers = new int[numbersString.length];

        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        int distance = Math.abs(numberN - numbers[0]);
        for (int n : numbers) {
            int absOne = Math.abs(numberN - n);
            if (distance > absOne) {
                distance = absOne;
            }
        }

        for (int n : numbers) {
            if (Math.abs(numberN - n) == distance) {
                list.add(n);
            }
        }

        Collections.sort(list);

        for (Integer value : list) {
            System.out.print(value + " ");
        }
        // write your code here
    }
}