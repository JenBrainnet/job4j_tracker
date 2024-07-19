package ru.job4j.record;

public record PersonRecord(String name, int age) implements Comparable<PersonRecord> {

    public static int maxAge = 100;

    public PersonRecord {
        if (age > 101) {
            try {
                throw new IllegalAccessException("Возраст должен быть менее 101");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getMaxAge() {
        return maxAge;
    }

    public void info() {
        System.out.println("Напечатать информацию");
    }

    @Override
    public String toString() {
        return "PersonRecord{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }

    @Override
    public int compareTo(PersonRecord o) {
        return name.compareTo(o.name);
    }

}
