package com.github.umidovalimardon06.isbnvalidator;

public interface ExternalISBNDataService {
    public Book lookup(String isbn);
}
