package com.company.Model;

import com.company.Interface.Sentient;

import java.util.ArrayList;
import java.util.List;

public class Person implements Sentient {

    private final String name;
    private final List<String> likes = new ArrayList<>();

    public Person(String name){
        this.name = name;
    }

    /**
     * Method to check if other sentient is in list of likes
     * @param other sentient / Person
     * @return true if other is liked by this sentient
     */
    @Override
    public boolean likes(Sentient other) {
        return likes.contains(other.getIdentity());
    }

    /**
     * Sets like based on identity which is a string
     * @param other the sentient to like
     */
    @Override
    public void setLikes(Sentient other) {
        likes.add(other.getIdentity());
    }

    @Override
    public String getIdentity() {
        return name;
    }
}

