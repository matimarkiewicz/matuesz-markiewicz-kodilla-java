package com.kodilla.patterns2.observer.homework;

import java.util.*;

public class Student implements Observable {
    private final String studentName;
    private final List<Observer> observers;
    private Map<String, String> homeworks;
    private final Course courseName;

    public Student(String studentName, Course courseName) {
        this.studentName = studentName;
        observers = new ArrayList<>();
        homeworks = new LinkedHashMap<>();
        this.courseName = courseName;
    }

    public void addHomework(String homeworkNumber, String answer) {
        homeworks.put(homeworkNumber, answer);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public Map<String, String> getHomeworks() {
        return homeworks;
    }

    public Course getCourseName() {
        return courseName;
    }
}
