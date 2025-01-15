package ru.job4j.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class QueueRunner {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("first");
        queue.add("second");
        queue.add("third");
        System.out.println("State of Queue before remove(): ");
        for (String string : queue) {
            System.out.println(string);
        }
        queue.poll();
        System.out.println();
        System.out.println("State of Queue after remove(): ");
        for (String string : queue) {
            System.out.println(string);
        }
        queue.clear();
        System.out.println("\npoll() with empty queue");
        String temp = queue.poll();
        System.out.println(temp);
        System.out.println("\noffer() with LinkedList<>");
        queue.offer("first");
        queue.offer("second");
        for (String string : queue) {
            System.out.println(string);
        }
        System.out.println("\noffer() with ArrayBlockingQueue<>(1)");
        Queue<String> blockingQueue = new ArrayBlockingQueue<>(1);
        blockingQueue.offer("first");
        blockingQueue.offer("second");
        for (String string : blockingQueue) {
            System.out.println(string);
        }
        System.out.println("\npeek(): " + queue.peek());
        System.out.println("element(): " + queue.element());
        queue.clear();
        System.out.println("peek() with empty queue: " + queue.peek());
    }

}
