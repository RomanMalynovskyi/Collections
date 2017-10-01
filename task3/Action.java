package com.gmail.malynovskyiroman.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Action {
    private Map<Char, Double> map;
    private char[] array;

    public Action(Map<Char, Double> map) {
        this.map = map;
    }

    public Map<Char, Double> getMap() {
        return map;
    }

    public void setMap(Map<Char, Double> map) {
        this.map = map;
    }

    public char[] getArray() {
        return array;
    }

    public void setArray(char[] array) {
        this.array = array;
    }

    public void fillCollection(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            stringBuilder.append(s);
        }
        bufferedReader.close();
        array = stringBuilder.toString().toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i])) {
                Char ch = new Char(array[i]);
                if (map.containsKey(ch)) {
                    ch.setQuantity((int) (map.remove(ch) + 1));
                } else {
                    ch.setQuantity(1);
                }
                map.put(ch, Double.valueOf(ch.getQuantity()));
            }
        }
    }

    private Map<Char, Double> calculateFreaquency(Map<Char, Double> map) {
        for (Map.Entry<Char, Double> pair : map.entrySet()) {
            pair.setValue((map.get(pair.getKey()) / array.length) * 100);
        }
        return map;
    }

    private List<Map.Entry<Char, Double>> sortByFreaquency(Map<Char, Double> map) {
        Map<Char, Double> map2 = calculateFreaquency(map);
        List<Map.Entry<Char, Double>> list = new ArrayList<>(map2.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Char, Double>>() {
            @Override
            public int compare(Map.Entry<Char, Double> o1, Map.Entry<Char, Double> o2) {
                return Double.compare(o2.getValue(), o1.getValue());
            }
        });
        return list;
    }

    public void printCollection() {
        List<Map.Entry<Char, Double>> list = sortByFreaquency(map);
        for (Map.Entry<Char, Double> pair : list) {
            System.out.println(pair.getKey() + " : " + String.format("%.2f", pair.getValue()));
        }
    }
}
