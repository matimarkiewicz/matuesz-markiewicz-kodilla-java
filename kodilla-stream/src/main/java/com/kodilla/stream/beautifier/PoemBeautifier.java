package com.kodilla.stream.beautifier;

import java.lang.*;

public class PoemBeautifier {

    public String beautify(String text, PoemDecorator poemDecorator) {
        return poemDecorator.decorate(text);
    }
}
