package ru.job4j.tracker;

import java.util.Arrays;

public class DropArray {

    public static void main(String[] args) {
        System.out.println("Arrays.copyOf(array, length) example:");
        String[] names = {"Petr", null, "Ivan", "Stepan", null};
        String[] result = new String[names.length];
        int size = 0;
        for (int index = 0; index < names.length; index++) {
            String name = names[index];
            if (name != null) {
                result[size] = name;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        for (int index = 0; index < result.length; index++) {
            System.out.println(result[index]);
        }
        System.out.println("System.arraycopy(source, startPos, dist, distPos, length) example:");
        String[] otherNames = {"Petr", null, "Ivan", "Stepan", "Fedor"};
        System.arraycopy(otherNames, 2, otherNames, 1, 3);
        System.out.println(Arrays.toString(otherNames));
    }

}
