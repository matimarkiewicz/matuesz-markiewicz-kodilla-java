package com.kodilla.stream;

import java.lang.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.*;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumUser.Forum;
import com.kodilla.stream.forumUser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {

    /*public static void main(String[] args) {

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");

        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");

        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String beautifulText01 = poemBeautifier.beautify("Text to beautify", (String::toUpperCase));
        System.out.println(beautifulText01);

        String beautifulText02 = poemBeautifier.beautify("Text to beautify", (text -> "ABC - " + text + " - ABC"));
        System.out.println(beautifulText02);

        String beautifulText03 = poemBeautifier.beautify("Text to beautify", (text -> text.replace(" ", "_")));
        System.out.println(beautifulText03);

        String beautifulText04 = poemBeautifier.beautify("Text to beautify", (text ->  "*" + text + "* has got " + text.length() + " letters."));
        System.out.println(beautifulText04);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }*/
    /*public static void main(String[] args) {
        People.getList().stream()
            .map(String::toUpperCase)
            .filter(s -> s.length() > 11)
            .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
            .filter(s -> s.substring(0, 1).equals("M"))
            .forEach(System.out::println);
    }*/
    /*public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
            .filter(book -> book.getYearOfPublication() > 2005)
            .forEach(System.out::println);
    }*/
    /*public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
            .filter(book -> book.getYearOfPublication() > 2005)
            .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
            .forEach(System.out::println);
     }*/
     /*public static void main(String[] args) {
         BookDirectory theBookDirectory = new BookDirectory();

         Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
            .filter(book -> book.getYearOfPublication() > 2005)
            .collect(Collectors.toMap(Book::getSignature, book -> book));

         System.out.println("# elements: " + theResultMapOfBooks.size());
         theResultMapOfBooks.entrySet().stream()
            .map(entry -> entry.getKey() + ": " + entry.getValue())
            .forEach(System.out::println);
     }*/
    /*public static void main(String[] args) {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }*/
    public static void main(String[]args) {

        Forum forum = new Forum();
        Map<Integer, ForumUser> mapOfUsers = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getBirthdayDate(), LocalDate.now()).getYears() >= 20)
                .filter(forumUser -> forumUser.getPostsQty() >= 1)
                .collect(Collectors.toMap(ForumUser::getIDNumber, ForumUser -> ForumUser));

        mapOfUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}
