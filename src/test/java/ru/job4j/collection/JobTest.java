package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class JobTest {

    @Test
    void whenComparatorByAscName() {
        int result = new JobAscByName().compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenComparatorByDescName() {
        int result = new JobDescByName().compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenComparatorByAscPriority() {
        int result = new JobAscByPriority().compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenComparatorByDescPriority() {
        int result = new JobDescByPriority().compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> nameAndPriorityComparator = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int result = nameAndPriorityComparator.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenComparatorByAscPriorityAndAscName() {
        Comparator<Job> priorityAndNameComparator = new JobAscByPriority()
                .thenComparing(new JobAscByName());
        int result = priorityAndNameComparator.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenComparatorByAskNameAndDescPriority() {
        Comparator<Job> nameAndPriorityComparator = new JobAscByName()
                .thenComparing(new JobDescByPriority());
        int result = nameAndPriorityComparator.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 0)
        );
        assertThat(result).isLessThan(0);
    }

}