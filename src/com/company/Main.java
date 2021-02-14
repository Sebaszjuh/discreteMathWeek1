package com.company;

import com.company.Interface.Sentient;
import com.company.Model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main{
    // Vx L(x,t)
    public static void main(String[] args) {
        List<Sentient> allDomain = prepareForAllDomain();
        List<Sentient> existDomain = prepareThereExistDomain();
        Predicate<Sentient> predicate = preparePredicate();
        boolean resultForAll = forAll(allDomain, predicate);
        boolean resultForAllShouldBeFalse = forAll(existDomain,predicate);
        boolean resultThereExists = thereExists(existDomain,predicate);
        System.out.println("True: " + resultForAll);
        System.out.println("False: " + resultForAllShouldBeFalse);
        System.out.println("True: " + resultThereExists);
    }

    /**
     * Method boolean to check given list of sentient matches predicate
     * @param existDomain list of sentient which some match the predicate
     * @param predicate Predicate is that they like trump
     * @return
     */
    private static boolean thereExists(List<Sentient> existDomain, Predicate<Sentient> predicate) {
        return existDomain.stream().anyMatch(predicate);
    }

    /**
     * Method boolean to check given list of sentient
     * @param allDomain All people who loves trump,
     * @param predicate Predicate is that they like Trump
     * @return true if all people in allDomain love trump
     */
    private static boolean forAll(List<Sentient> allDomain, Predicate<Sentient> predicate) {
        return allDomain.stream().allMatch(predicate);
    }

    private static Predicate<Sentient> preparePredicate() {
        return p -> p.likes(new Person("Trump"));
    }

    /**
     * Method for setup sentients
     * @return List of sentients which love trump and others
     */
    private static List<Sentient> prepareThereExistDomain() {
        List<Sentient> ad = new ArrayList<>();
        Person trump = new Person("Trump");
        Person biden = new Person("Biden");
        Person a = new Person("A");
        Person b = new Person("B");
        Person c = new Person("C");
        a.setLikes(trump);
        b.setLikes(trump);
        b.setLikes(new Person("Hillary"));
        c.setLikes(biden);
        ad.add(a);
        ad.add(b);
        ad.add(c);
        return ad;
    }

    /**
     * Method for setup sentients
     * @return list of sentients that only love trump
     */
    private static List<Sentient> prepareForAllDomain() {
        List<Sentient> ad = new ArrayList<>();
        Person trump = new Person("Trump");
        Person a = new Person("Klaas");
        Person b = new Person("Jan");
        Person c = new Person("Redneck");
        a.setLikes(trump);
        b.setLikes(trump);
        c.setLikes(trump);
        ad.add(a);
        ad.add(b);
        ad.add(c);
        return ad;
    }

}
