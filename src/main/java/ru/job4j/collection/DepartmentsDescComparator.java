package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int result = getRootDepartment(right)
                .compareTo(getRootDepartment(left));
        return result != 0 ? result : left.compareTo(right);
    }

    private String getRootDepartment(String department) {
        return department.split("/", 2)[0];
    }

}
