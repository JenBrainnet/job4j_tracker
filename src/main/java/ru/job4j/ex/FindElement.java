package ru.job4j.ex;

public class FindElement {

    public static int indexOf(String[] values, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < values.length; i++) {
            if (key.equals(values[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] values = {"Amazon", "Ebay"};
        try {
            indexOf(values, "Ozon");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

}
