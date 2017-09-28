package com.gmail.malynovskyiroman.task1;

       /* Написать метод, который создаст список, положит в него 10
        элементов, затем удалит первые два и последний, а затем выведет
        результат на экран.*/

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        fillList();
    }

    public static void fillList() {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);

        System.out.println(list);
    }
}
