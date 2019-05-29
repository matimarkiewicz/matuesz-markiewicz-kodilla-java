package com.kodilla.testing.library;

import org.junit.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {

        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);

        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {

        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {

        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfZeroBooks(){

        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOfZeroBooks = generateListOfNBooks(0);
        LibraryUser user = new LibraryUser("", "", "");

        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(listOfZeroBooks);

        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(user);

        assertEquals(0, resultListBooksInHandsOf.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(any(LibraryUser.class));
    }

    @Test
    public void testListBooksInHandsOfOneBook(){

        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOfOneBooks = generateListOfNBooks(1);
        LibraryUser user = new LibraryUser("", "", "");

        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(listOfOneBooks);

        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(user);

        assertEquals(1, resultListBooksInHandsOf.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(any(LibraryUser.class));
    }

    @Test
    public void testListBooksInHandsOfFiveBooks(){

        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOfFiveBooks = generateListOfNBooks(5);
        LibraryUser user = new LibraryUser("", "", "");

        when(libraryDatabaseMock.listBooksInHandsOf(any(LibraryUser.class))).thenReturn(listOfFiveBooks);

        List<Book> resultListBooksInHandsOf = bookLibrary.listBooksInHandsOf(user);

        assertEquals(5, resultListBooksInHandsOf.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(any(LibraryUser.class));
    }
}
