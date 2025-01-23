package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(extractNumber(left), extractNumber(right));
    }

    private int extractNumber(String str) {
        String numberAsString = str.split("\\.")[0];
        return Integer.parseInt(numberAsString);
    }

}
