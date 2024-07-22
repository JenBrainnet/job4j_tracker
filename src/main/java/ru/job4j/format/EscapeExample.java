package ru.job4j.format;

public class EscapeExample {

    public static void main(String[] args) {
        String str = "Я изучаю на \"Job4j\" экранирование символов";
        System.out.println(str);
        char escape = '"';
        System.out.println(escape);
        escape = '\'';
        System.out.println(escape);
        str = "Я изучаю на 'Job4j' экранирование символов";
        System.out.println(str);
        String path = "C:\\projects\\job4j\\File.java";
        System.out.println(path);
        System.out.print("Старый длинный текст\r");
        System.out.println("Новый текст");
        System.out.print("Первая строка\nВторая строка\n");
        System.out.println("Без отступа");
        System.out.println("\tОдин отступ");
        System.out.println("\t\tДва отступа");
        System.out.println("Job4jjj\b\b");
    }

}
