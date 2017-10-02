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

    public char[] getArray() {
        return array;
    }

    public void fillCollection(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String s;
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

    private Map<Char, Double> calculateFrequency(Map<Char, Double> map) {
        for (Map.Entry<Char, Double> pair : map.entrySet()) {
            pair.setValue((map.get(pair.getKey()) / array.length) * 100);
        }
        return map;
    }

    private List<Map.Entry<Char, Double>> sortByFrequency(Map<Char, Double> map) {
        Map<Char, Double> map2 = calculateFrequency(map);
        List<Map.Entry<Char, Double>> list = new ArrayList<>(map2.entrySet());
        Collections.sort(list, (o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        return list;
    }

    public void printCollection() {
        List<Map.Entry<Char, Double>> list = sortByFrequency(map);
        list.forEach(entry -> System.out.println(entry.getKey() + " : " + String.format("%.2f", entry.getValue())));
    }
}
