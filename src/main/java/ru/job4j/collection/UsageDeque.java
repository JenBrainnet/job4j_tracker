package ru.job4j.collection;

import java.util.*;

public class UsageDeque {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Deque<String> deque = new LinkedList<>();
        deque.add("second");
        deque.addFirst("first");
        deque.addLast("third");
        for (String string : deque) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println(deque);
        System.out.println(deque.pop());
        System.out.println(deque.poll());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println();
        deque.addAll(Arrays.asList("first", "second", "third"));
        Iterator<String> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        Iterator<String> descIterator = deque.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.println(descIterator.next());
        }
    }

}
