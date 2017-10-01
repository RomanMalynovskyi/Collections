package com.gmail.malynovskyiroman.task3;

        /*
        Считайте из файла текст на английском языке, вычислите
        относительную частоту повторения каждой буквы и выведите на
        экран результат в порядке убывания относительной частоты
        повторения.
        */

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Action action = new Action(new TreeMap<>(new CharComparator()));
        try {
            action.fillCollection("z://src.doc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(action.getArray()));
        action.printCollection();
    }
}
