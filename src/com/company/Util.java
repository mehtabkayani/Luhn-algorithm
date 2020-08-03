package com.company;

import java.util.Scanner;

public class Util {

    public boolean checkSum(String digits) {
        String card = digits;
        digits.toCharArray();
        int cardDigitsLength = digits.length();
        int lastDigit = Character.getNumericValue(digits.charAt(digits.length() - 1));

        //Drop the last digit.
        card = card.substring(0, (card.length() - 1));

        //Reverse the digits.
        String cardReverse = new StringBuilder(card).reverse().toString();

        //Store the reversed card in char[]
        char[] cardArray = cardReverse.toCharArray();

        //Store the reversed char[] in an int array.
        int[] cardCopy = new int[cardArray.length];
        int sum = 0;

        for (int i = 0; i < cardArray.length; i++) {
            cardCopy[i] = Character.getNumericValue(cardArray[i]);
        }

        //multiply digit. (digit*2).
        for (int j = 0; j < cardCopy.length; j++) {
            if ((j % 2) == 0) {
                cardCopy[j] = cardCopy[j] * 2;
            }
        }

        //Subtract 9 from digits larger than 9.

        for (int k = 0; k < cardCopy.length; k++) {
            if (cardCopy[k] > 9) {
                cardCopy[k] = cardCopy[k] - 9;
            }
        }

        //Add all the numbers together.
        for (int l = 0; l < cardCopy.length; l++) {
            sum += cardCopy[l];
        }

        //check if sum * 9 divided by 10 has a remainder equal to the check number.
        if (sum * 9 % 10 == lastDigit) {
            int expected = sum * 9  % 10;
            System.out.println("Provided " + lastDigit);
            System.out.println("Expected " + expected);
            System.out.println();
            System.out.println();
            System.out.println("Checksum: Valid");
            System.out.print("Digits: " + cardDigitsLength);
            if (isCreditCard(cardDigitsLength)) {
                System.out.println(" (credit card)");
            }

            return true;
        } else {
            int expected = sum * 9 % 10;

            System.out.println("Provided " + lastDigit);
            System.out.println("Expected " + expected);
            System.out.println();
            System.out.println();
            System.out.println("Checksum: Invalid");
            System.out.println("Digits: " + cardDigitsLength);

            return false;
        }
    }

    public boolean isCreditCard(int digitsLength) {
        if (digitsLength == 16) {
            return true;
        }
        return false;
    }


    public void start(String digits) {
        //Prints the digit with the last digit separated
        returnDigits(digits);
        //provides the checkSum() with the input from user.
        checkSum(digits);

    }

    //Returns the digits with last digit separated
    public String returnDigits(String digits) {
        char[] originalDigits = digits.toCharArray();
        String returnDigits = digits.substring(0, digits.length() - 1) + " " + digits.substring(digits.length() - 1);
        System.out.println(returnDigits);
        return returnDigits;
    }

    public String getDigitsFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your card number: ");

        String input;
        while (true) {
            input = scanner.next();
            //Checks if the input only contains positive digits
            if (validateInput(input)) {
                break;
            } else {
                System.out.print("Invalid input. Please reenter your card number: ");
                scanner.nextLine();
            }
        }
        return input;
    }


    //Checks if the given string only contains positive digits
    public boolean validateInput(String str) {
        return str.matches("^[0-9]*$");
    }


}



