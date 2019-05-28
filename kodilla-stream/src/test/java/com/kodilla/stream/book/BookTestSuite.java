package com.kodilla.stream.book;

import org.junit.*;
import java.util.*;
import java.util.stream.*;

public class BookTestSuite {
    @Test
    public void testGetListUsingFor() {

        BookDirectory bookDirectory = new BookDirectory();

        List<Book> books = bookDirectory.getList();

        int numberOfBooksPublicatedAfter2007 = 0;
        for(Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
    @Test
    public void testGetListUsingIntStream() {

        BookDirectory bookDirectory = new BookDirectory();

        List<Book> books = bookDirectory.getList();

        long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}