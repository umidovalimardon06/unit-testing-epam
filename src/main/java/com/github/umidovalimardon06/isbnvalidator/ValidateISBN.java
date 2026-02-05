package com.github.umidovalimardon06.isbnvalidator;

public class ValidateISBN {
    public boolean isValid(String isbn) {
        if (isbn.length() != 10) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            sum += (c - '0') * (10 - i);
        }

        char lastChar = isbn.charAt(9);
        if (lastChar == 'X') {
            sum += 10;
        } else if (Character.isDigit(lastChar)) {
            sum += lastChar - '0';
        } else {
            return false;
        }
        return sum % 11 == 0;
    }
}
