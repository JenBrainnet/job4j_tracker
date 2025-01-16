package ru.job4j.collection;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder result = new StringBuilder();
        Iterator<Character> iterator = evenElements.iterator();
        for (int i = 0; i < evenElements.size(); i += 2) {
            result.append(iterator.next());
            iterator.next();
        }
        return result.toString();
    }

    private String getDescendingElements() {
        StringBuilder result = new StringBuilder();
        Iterator<Character> descIterator = descendingElements.descendingIterator();
        while (descIterator.hasNext()) {
            result.append(descIterator.next());
        }
        return result.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }

}
