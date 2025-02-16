package ru.job4j.builder;

public class BuilderUsage {

    public static void main(String[] args) {
        User user = new User.Builder().buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user);
    }

}
