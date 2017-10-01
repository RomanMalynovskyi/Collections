package com.gmail.malynovskyiroman.task3;

import java.util.Comparator;

public class CharComparator implements Comparator<Char> {
    @Override
    public int compare(Char o1, Char o2) {
        return Integer.compare(o1.getSymbol(), o2.getSymbol());
    }
}
