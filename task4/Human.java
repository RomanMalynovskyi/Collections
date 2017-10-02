package com.gmail.malynovskyiroman.task4;

public class Human {

    private String name;
    private DoubleColaAutomat doubleColaAutomat;

    public Human(String name, DoubleColaAutomat doubleColaAutomat) {
        this.name = name;
        this.doubleColaAutomat = doubleColaAutomat;
    }

    public Human() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void drinkCola() {
        Human human = doubleColaAutomat.getQueue().pollFirst();
        doubleColaAutomat.getQueue().offerLast(human);
        doubleColaAutomat.getQueue().offerLast(human);
    }

    @Override
    public String toString() {
        return name;
    }
}
