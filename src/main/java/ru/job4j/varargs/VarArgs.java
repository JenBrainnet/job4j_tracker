package ru.job4j.varargs;

public class VarArgs {

    public static String text(String string) {
        return string;
    }

    public static String text(String... strings) {
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static String text(int x, String... strings) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        for (String string : strings) {
            builder.append(string);
        }
        return builder + " Количество соединенных элементов: " + strings.length;
    }

    public static void main(String[] args) {
        System.out.println("Вызов text(String string):");
        System.out.println(text("aaa"));
        System.out.println("Вызов text(String... strings):");
        System.out.println(text());
        System.out.println(text("aaa", "bbb"));
        System.out.println("Вызов text(int x, String... strings):");
        System.out.println(text(1));
        System.out.println(text(1, "aaa"));
        System.out.println(text(1, "aaa", "bbb", "ccc"));
    }

}
