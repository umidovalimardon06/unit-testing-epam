package com.github.umidovalimardon06.isbnvalidator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockManagementTest {
    @Test
    public void testCanGetACorrectLocatorCode() {

        ExternalISBNDataService service = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn,"Of Mice and Men","J. Steinbeck");
            }
        };

        StockManager stockManager = new StockManager();
        stockManager.setService(service);

        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);
    }


}
