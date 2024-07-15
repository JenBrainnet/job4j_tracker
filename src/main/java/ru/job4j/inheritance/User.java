package ru.job4j.inheritance;

public class User extends Base {

    public User() {
        System.out.println("Default User Constructor");
    }

    public static void main(String[] args) {
        User user = new User();
    }

}
