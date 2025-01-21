package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemTest {

    @Test
    void whenSortItemsInAscOrder() {
        List<Item> items = Arrays.asList(
                new Item(2, "item 2"),
                new Item(3, "item 3"),
                new Item(1, "item 1")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "item 1"),
                new Item(2, "item 2"),
                new Item(3, "item 3")
        );
        assertThat(items).containsExactlyElementsOf(expected);
    }

    @Test
    void whenSortItemsInDescOrder() {
        List<Item> items = Arrays.asList(
                new Item(2, "item 2"),
                new Item(3, "item 3"),
                new Item(1, "item 1")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "item 3"),
                new Item(2, "item 2"),
                new Item(1, "item 1")
        );
        assertThat(items).containsExactlyElementsOf(expected);
    }

}