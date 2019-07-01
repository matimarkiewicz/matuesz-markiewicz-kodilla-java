package com.kodilla.good.patterns.allegro;

import java.util.*;
import java.io.*;
import java.lang.*;

public class MailService implements InformationService {
    public void inform(User user) {
        System.out.println("Thank You " + user.getUserName());
    }
}