package com.github.umidovalimardon06.isbnvalidator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTest {
    ExternalISBNDataService databaseService;
    ExternalISBNDataService webService;
    StockManager stockManager;

    @Before
    public void setup() {
        System.out.println("setup running");
        databaseService = mock(ExternalISBNDataService.class);
        webService = mock(ExternalISBNDataService.class);
        stockManager = new StockManager();
        stockManager.setDatabaseService(databaseService);
        stockManager.setWebService(webService);
    }

    @Test
    public void testCanGetACorrectLocatorCode() {
        when(databaseService.lookup(anyString())).thenReturn(new Book("0140177396","Of Mice and Men","J. Steinbeck"));
        when(webService.lookup(anyString())).thenReturn(null);
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4",locatorCode);
    }

    @Test
    public void databaseUsedIfDataIsPresent() {
        when(databaseService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(databaseService,times(1)).lookup("0140177396");
        verify(webService,never()).lookup(anyString());
    }

    @Test
    public void webserviceIsUsedIfDataIsNotPresentInDatabase() {
        when(databaseService.lookup("0140177396")).thenReturn(null);
        when(webService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
        String isbn = "0140177396";
        String locatorCode = stockManager.getLocatorCode(isbn);
        verify(databaseService,times(1))
                .lookup("0140177396");
        verify(webService,times(1))
                .lookup("0140177396");
    }

}





