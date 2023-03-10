package com.assignment.javaspringbootassignment.entity;

import org.springframework.stereotype.Component;

@Component
public class Candidate {
    private String name;
    private int count;

    public Candidate() {
    }

    public Candidate(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
