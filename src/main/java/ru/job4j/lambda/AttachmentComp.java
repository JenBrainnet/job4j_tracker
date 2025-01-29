package ru.job4j.lambda;

import java.util.Comparator;

public class AttachmentComp implements Comparator<Attachment> {

    @Override
    public int compare(Attachment left, Attachment right) {
        return Integer.compare(left.getSize(), right.getSize());
    }

}
