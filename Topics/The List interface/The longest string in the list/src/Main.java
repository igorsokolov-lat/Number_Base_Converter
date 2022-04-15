import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        // write your code here
        int wordLength = 0;
        String longestWord = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > wordLength) {
                wordLength = list.get(i).length();
                longestWord = list.get(i);
            }
        }
        Collections.fill(list, longestWord);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}