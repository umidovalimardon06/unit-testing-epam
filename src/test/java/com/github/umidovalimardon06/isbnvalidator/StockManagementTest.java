package com.github.umidovalimardon06.isbnvalidator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class StockManagementTest {
    @Test
    public void testCanGetACorrectLocatorCode() {
        ExternalISBNDataService webService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn,"Of Mice and Men","J. Steinbeck");
            }
        };
        ExternalISBNDataService databaseService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };
        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);
    }

    @Test
    public void databaseUsedIfDataIsPresent() {
        /// gives us a dummy class
        ExternalISBNDataService databaseService =
                mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService =
                mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0140177396")).thenReturn(
                new Book("0140177396","abc","abc")
        );

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);

        verify(databaseService,times(1))
                .lookup("0140177396");
    }

    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        /// gives us a dummy class
        ExternalISBNDataService databaseService =
                mock(ExternalISBNDataService.class);
        ExternalISBNDataService webService =
                mock(ExternalISBNDataService.class);

        when(databaseService.lookup("0140177396")).thenReturn(null);
        when(webService.lookup("0140177396")).thenReturn(
                new Book("0140177396","abc","abc")
        );

        StockManager stockManager = new StockManager();
        stockManager.setWebService(webService);
        stockManager.setDatabaseService(databaseService);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);

        verify(databaseService,times(1))
                .lookup("0140177396");
        verify(webService,times(1))
                .lookup("0140177396");
    }


}





