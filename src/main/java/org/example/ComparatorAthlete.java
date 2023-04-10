package org.example;

import java.util.Comparator;

/**
 * This is a class that implements the Comparator class.
 */
public class ComparatorAthlete implements Comparator<Athlete> {
    /**
     * This is a method that override the compare method.
     *
     * @param e1 – the first object to be compared;
     * @param e2 – the second object to be compared;
     */
    @Override
    public int compare(Athlete e1, Athlete e2) {

        return (e1.athleteName).compareTo(e2.athleteName);
    }
}
