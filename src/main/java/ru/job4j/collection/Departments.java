package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> departments) {
        Set<String> uniqueDepartments = new LinkedHashSet<>();
        for (String value : departments) {
            String start = "";
            for (String element : value.split("/")) {
                if (!start.isEmpty()) {
                    start += "/";
                }
                start += element;
                uniqueDepartments.add(start);
            }
        }
        return new ArrayList<>(uniqueDepartments);
    }

    public static void sortAsc(List<String> departments) {
        Collections.sort(departments);
    }

    public static void sortDesc(List<String> departments) {
        departments.sort(new DepartmentsDescComparator());
    }

}
