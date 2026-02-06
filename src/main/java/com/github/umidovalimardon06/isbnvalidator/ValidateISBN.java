package com.github.umidovalimardon06.isbnvalidator;

public class ValidateISBN {
    public boolean isValid(String isbn) {
        final int LENGTH = 10;
        final Character CHAR = 'X';

        if (isbn.length() != LENGTH) {
            throw new NumberFormatException();
        }

        int sum = 0;
        for (int i = 0; i < LENGTH-1; i++) {
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) {
                throw new NumberFormatException();
            }
            sum += (c - '0') * (10 - i);
        }

        char lastChar = isbn.charAt(LENGTH-1);
        if (lastChar == CHAR) {
            sum += 10;
        } else if (Character.isDigit(lastChar)) {
            sum += lastChar - '0';
        } else {
            return false;
        }
        return sum % 11 == 0;
    }
}
