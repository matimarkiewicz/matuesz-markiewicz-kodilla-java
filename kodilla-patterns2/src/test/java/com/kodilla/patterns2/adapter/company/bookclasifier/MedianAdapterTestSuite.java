package com.kodilla.patterns2.adapter.company.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.*;

import java.util.*;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {

        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookLibrary = new HashSet<>();
       bookLibrary.add(new Book("Olga Nawoja Tokarczuk",
                "Bieguni",
                2007,
                "121315"));
        bookLibrary.add(new Book("Olga Nawoja Tokarczuk",
                "Księgi Jakubowe",
                2014,
                "154132"));
        bookLibrary.add(new Book("Peter Handke",
                "Gestern unterwegs",
                2005,
                "324253"));
        bookLibrary.add(new Book("Peter Handke",
                "Die Kunst des Fragens",
                1994,
                "546234"));
        bookLibrary.add(new Book("Stanisław Lem",
                "Solaris",
                1961,
                "159684"));

        int median = medianAdapter.publicationYearMedian(bookLibrary);

        Assert.assertEquals(2005, median);
    }
}
