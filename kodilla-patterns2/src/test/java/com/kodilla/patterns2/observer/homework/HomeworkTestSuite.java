package com.kodilla.patterns2.observer.homework;

import org.junit.*;

public class HomeworkTestSuite {

    @Test
    public void testUpdateHomeworks(){

        Student janekKlos = new Student("Janek Kłos", Course.Java_Developer);
        Student rysiekOdKlanu  =new Student("Rysiek z Klanu", Course.Java_Developer);

        Mentor bruce_willis = new Mentor("Bruce Willis");
        Mentor bruce_lee = new Mentor("Bruce Lee");

        janekKlos.registerObserver(bruce_lee);
        rysiekOdKlanu.registerObserver(bruce_willis);

        janekKlos.addHomework("20.3", "JavaScript");
        janekKlos.addHomework("20.4","Ajax");
        rysiekOdKlanu.addHomework("15.1","Singleton");
        rysiekOdKlanu.addHomework("15.2", "Prototype");

        Assert.assertEquals(2,bruce_lee.getUpdateCount());
        Assert.assertEquals(2,bruce_willis.getUpdateCount());
    }
}
