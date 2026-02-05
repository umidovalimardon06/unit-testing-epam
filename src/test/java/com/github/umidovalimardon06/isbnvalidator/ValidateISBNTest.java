package com.github.umidovalimardon06.isbnvalidator;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void validISBN10ReturnsTrue() {
        ValidateISBN validator = new ValidateISBN();
        assertTrue(validator.isValid("0140449116"));
    }

    @Test
    public void invalidISBN10ReturnsFalse() {
        ValidateISBN validator = new ValidateISBN();
        assertFalse(validator.isValid("0140449117"));
    }

    @Test
    public void isbn10EndingWithXIsValid() {
        ValidateISBN validator = new ValidateISBN();
        assertTrue(validator.isValid("012000030X"));
    }

    @Test
    public void isbnWithWrongLengthIsInvalid() {
        ValidateISBN validator = new ValidateISBN();
        assertFalse(validator.isValid("12345"));
    }
}
