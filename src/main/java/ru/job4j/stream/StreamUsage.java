package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );

        List<Task> bugs = tasks.stream().filter(
                task -> task.name.contains("Bug")
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);

        List<Task> taskContainer = new ArrayList<>();
        for (Task task : tasks) {
            if ("BUG".equals(task.name)) {
                taskContainer.add(task);
            }
        }

        List<String> names = tasks.stream().map(
                task -> task.name
        ).toList();

        List<String> namesContainer = new ArrayList<>();
        for (Task task : tasks) {
            namesContainer.add(task.name);
        }

        long total = tasks.stream().map(
                task -> task.spent
        ).reduce(0L, Long::sum);

        long spentTotal = 0L;
        for (Task task : tasks) {
            total += task.spent;
        }
    }

}
