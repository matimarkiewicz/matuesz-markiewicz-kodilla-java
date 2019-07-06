package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BoardConfig {
    @Bean
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }

    private TaskList getToDoList() {
        return new TaskList();
    }

    private TaskList getInProgressList() {
        return new TaskList();
    }

    private TaskList getDoneList() {
        return new TaskList();
    }
}
