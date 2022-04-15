package converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean mainFlag = true;
        boolean flag = true;

        while (mainFlag) {
            System.out.println("Enter to numbers in format: {source base} {target base} (To quit type /exit)");
            String choice = scanner.nextLine();

            switch (choice) {
                case "/exit":
                    mainFlag = false;
                    break;

                default:
                    String[] base = choice.split(" ");
                    BigDecimal sourceBase = new BigDecimal(base[0]);
                    BigDecimal targetBase = new BigDecimal(base[1]);
                    while (flag) {
                        System.out.println("Enter number in base " + sourceBase + " to convert to base " + targetBase + " (To go back type /back)");
                        String number = scanner.nextLine();

                        switch (number) {
                            case "/back":
                                flag = false;
                                break;

                            default:
                                if (sourceBase.equals(BigDecimal.TEN)) {
                                    System.out.println("Conversion result: " + fromDecimal(number, targetBase, sourceBase));
                                } else if (targetBase.equals(BigDecimal.TEN)) {
                                    if (toDecimal(number, sourceBase).subtract(toDecimal(number, sourceBase).setScale(0, RoundingMode.DOWN)).compareTo(BigDecimal.ZERO) == 0) {
                                        System.out.println("Conversion result: " + toDecimal(number, sourceBase).setScale(0, RoundingMode.DOWN));
                                    } else {
                                        System.out.println("Conversion result: " + toDecimal(number, sourceBase).setScale(5, RoundingMode.HALF_UP));
                                    }
                                } else {
                                    toDecimal(number, sourceBase);
                                    String result = fromDecimal(number, targetBase, sourceBase);
                                    System.out.println("Conversion result: " + result);
                                }
                                break;
                        }
                    }
                    flag = true;
            }
        }
    }
    // write your code here

    public static String fromDecimal(String number, BigDecimal targetBase, BigDecimal sourceBase) {


        String baseNumberInteger = "";
        String baseNumberFraction = "";
        String resultingBaseNumber;
        int i = 0;
        boolean fractionFlag = true;

        BigDecimal decimalNumberInteger;
        BigDecimal decimalNumberFraction = BigDecimal.ZERO;
        String decimalNumber = toDecimal(number, sourceBase).toPlainString();

        if (sourceBase.compareTo(BigDecimal.TEN) != 0) {
            decimalNumberInteger = new BigDecimal(decimalNumber).setScale(0, RoundingMode.DOWN);
            decimalNumberFraction = new BigDecimal(decimalNumber).subtract(decimalNumberInteger);
        } else {
            decimalNumberInteger = new BigDecimal(number).setScale(0, RoundingMode.DOWN);
            decimalNumberFraction = new BigDecimal(number).subtract(decimalNumberInteger);
        }

        char charList[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        if (decimalNumberFraction.toString().equals("0") == true) {
            fractionFlag = false;
        }

        if (decimalNumberInteger.compareTo(BigDecimal.ZERO) == 0) {
            baseNumberInteger = "0";
        } else {
            while (decimalNumberInteger.compareTo(BigDecimal.ZERO) == 1) {
                BigDecimal remainder = decimalNumberInteger.remainder(targetBase);
                baseNumberInteger = charList[remainder.intValue()] + baseNumberInteger;
                decimalNumberInteger = decimalNumberInteger.divide(targetBase, 0, RoundingMode.DOWN);
            }
        }

        while (i < 5 && fractionFlag) {
            BigDecimal remainder = decimalNumberFraction.multiply(targetBase);
            baseNumberFraction = baseNumberFraction + charList[remainder.intValue()];
            decimalNumberFraction = remainder.subtract(remainder.setScale(0, RoundingMode.DOWN));
            i++;
        }

        if (fractionFlag == false) {
            resultingBaseNumber = baseNumberInteger;
        } else {
            resultingBaseNumber = baseNumberInteger + "." + baseNumberFraction;
        }
        return resultingBaseNumber;
    }

    public static BigDecimal toDecimal(String number, BigDecimal sourceBase) {

        number = number.toUpperCase();

        boolean flagFraction = true;
        String[] numbers = number.split("\\.");
        String numberInteger = numbers[0];
        String numberFraction = "";

        if (numbers.length != 1) {
            numberFraction = numbers[1];
        } else {
            flagFraction = false;
        }

        BigDecimal resultingDecimalNumber;
        BigDecimal newDecimalNumberInteger = BigDecimal.ZERO;
        BigDecimal newDecimalNumberFraction = BigDecimal.ZERO;

        for (int i = 0; i < numberInteger.length(); i++) {
            char c = Character.valueOf(numberInteger.charAt(i));
            BigDecimal d = BigDecimal.valueOf(Character.getNumericValue(c));
            newDecimalNumberInteger = sourceBase.multiply(newDecimalNumberInteger).add(d);
        }

        for (int i = 0; i < numberFraction.length() && flagFraction; i++) {
            char c = Character.valueOf(numberFraction.charAt(i));
            BigDecimal d = BigDecimal.valueOf(Character.getNumericValue(c));
            newDecimalNumberFraction = newDecimalNumberFraction.add(d.multiply(BigDecimal.ONE.divide(sourceBase.pow(i + 1), 20, RoundingMode.DOWN)));
        }

        if (flagFraction == false) {
            resultingDecimalNumber = newDecimalNumberInteger;
        } else {
            resultingDecimalNumber = newDecimalNumberInteger.add(newDecimalNumberFraction);
        }

        return resultingDecimalNumber;
    }
}
