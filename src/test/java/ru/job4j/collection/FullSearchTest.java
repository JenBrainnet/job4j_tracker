package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class FullSearchTest {

    @Test
    void whenExtractNumberWithDuplicates() {
        FullSearch fullSearch = new FullSearch();
        List tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        var expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }

    @Test
    void whenExtractNumberWithUniqueTasks() {
        FullSearch fullSearch = new FullSearch();
        List tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("3", "Third desc")
        );
        var expected = new HashSet<>(Arrays.asList("1", "2", "3"));
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }

    @Test
    void whenExtractNumberWithEmptyList() {
        FullSearch fullSearch = new FullSearch();
        List tasks = List.of();
        assertThat(fullSearch.extractNumber(tasks)).isEmpty();
    }

    @Test
    void whenExtractNumberWithAllTasksHavingSameNumber() {
        FullSearch fullSearch = new FullSearch();
        List tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("1", "Second desc"),
                new Task("1", "Third desc")
        );
        var expected = Set.of("1");
        assertThat(fullSearch.extractNumber(tasks)).containsAll(expected);
    }

}