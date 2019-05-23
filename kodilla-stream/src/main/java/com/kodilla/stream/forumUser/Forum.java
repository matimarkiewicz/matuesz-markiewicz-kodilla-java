package com.kodilla.stream.forumUser;

import java.time.*;
import java.util.*;

public final class Forum {
    private final List<ForumUser> UserList = new ArrayList<>();

    public Forum() {
        UserList.add(new ForumUser(1, "Anna", 'F', LocalDate.of(1988, Month.FEBRUARY, 3),11));
        UserList.add(new ForumUser(2, "Beata", 'F', LocalDate.of(1984, Month.MARCH, 15),18));
        UserList.add(new ForumUser(3, "Celina", 'F', LocalDate.of(2005, Month.JANUARY, 15),7));
        UserList.add(new ForumUser(4, "Daria", 'F', LocalDate.of(1981, Month.APRIL, 13),0));
        UserList.add(new ForumUser(5, "Adam", 'M', LocalDate.of(1989, Month.APRIL, 22),14));
        UserList.add(new ForumUser(6, "Bartek", 'M', LocalDate.of(1987, Month.OCTOBER, 30),19));
        UserList.add(new ForumUser(7, "Cyprian", 'M', LocalDate.of(2001, Month.MAY, 31),0));
        UserList.add(new ForumUser(8, "Darek", 'M', LocalDate.of(1978, Month.NOVEMBER, 13),9));
        UserList.add(new ForumUser(9, "Emil", 'M', LocalDate.of(1982, Month.AUGUST, 24),7));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(UserList);
    }
}
