package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс демонстрирует использование лямбда-выражений для создания компараторов.
 * @author Leontyeva Evgeniya
 * @version 1.0
 */
public class FI {

    public static void main(String[] args) {
        Attachment[] attachments = {
                new Attachment("image 1", 20),
                new Attachment("image 2", 120),
                new Attachment("image 3", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            return Integer.compare(left.getSize(), right.getSize());
        };
        Arrays.sort(attachments, comparator);
        Comparator<String> comparatorSize =
                (left, right) -> Integer.compare(left.length(), right.length());
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize =
                (left, right) -> Integer.compare(right.length(), left.length());
    }

}
