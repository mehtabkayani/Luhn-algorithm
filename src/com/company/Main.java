package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        Dummy "card numbers"
        6796531236543269
        4242424242424242
        6796531236543210
         */

        Util util = new Util();

        String digits = util.getDigitsFromUser();

        util.start(digits);




    }
}
