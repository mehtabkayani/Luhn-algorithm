package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {
    Util util = new Util();

    @Test
    void validCheckSum() {
        assertTrue(util.checkSum("4242424242424242"));
        assertTrue(util.checkSum("6796531236543269"));
        assertTrue(util.checkSum("4579990896687535"));
        assertTrue(util.checkSum("5799908966875237"));
    }

    @Test
    void invalidCheckSum() {
        assertFalse(util.checkSum("4242424242424243"));
        assertFalse(util.checkSum("6796531236543263"));

        assertFalse(util.checkSum("6796531236003263"));
        assertFalse(util.checkSum("4242424242424246"));

    }


    @Test
    void returnDigits() {
        String str = "123456789";
        String str2 = "6796531236543269";

        assertEquals("12345678 9", util.returnDigits(str));
        assertEquals("679653123654326 9", util.returnDigits(str2));
    }

    @Test
    void isCreditCard() {
        assertTrue(util.isCreditCard(16));
    }

    @Test
    void isNotCreditCard() {
        assertFalse(util.isCreditCard(1));
        assertFalse(util.isCreditCard(5));
        assertFalse(util.isCreditCard(15));
        assertFalse(util.isCreditCard(20));
        assertFalse(util.isCreditCard(13));
    }


    @Test
    void isValidInput() {
        assertTrue(util.validateInput("12345678"));
        assertTrue(util.validateInput("4242424242424242"));
        assertTrue(util.validateInput("9047788856611280"));
        assertTrue(util.validateInput("4242424778885661"));
        assertTrue(util.validateInput("1280424778883434"));
    }

    @Test
    void isNotAValidInput() {
        assertFalse(util.validateInput("12345678f"));
        assertFalse(util.validateInput("abcdefghij"));
        assertFalse(util.validateInput("f2345678"));
        assertFalse(util.validateInput("#345678f"));
        assertFalse(util.validateInput("$345678"));
    }
}