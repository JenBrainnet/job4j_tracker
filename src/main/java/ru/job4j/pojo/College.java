package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Petr Arsentev");
        student.setGroup("RIZ-21021");
        student.setEnrolled(LocalDate.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        LocalDate enrolled = student.getEnrolled();
        String enrolledFormat = enrolled.format(formatter);
        System.out.println(
                student.getFullName() + " has been studying in " + student.getGroup()
                + " group since " + enrolledFormat
        );
    }

}
