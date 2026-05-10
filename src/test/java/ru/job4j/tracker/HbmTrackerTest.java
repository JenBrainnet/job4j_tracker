package ru.job4j.tracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @BeforeEach
    void clearItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            tracker.findAll().forEach(item -> tracker.delete(item.getId()));
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    void whenReplaceItemThenTrackerHasUpdatedItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("old name");
            tracker.add(item);
            Item updatedItem = new Item("new name");
            boolean result = tracker.replace(item.getId(), updatedItem);
            assertThat(result).isTrue();
            assertThat(tracker.findById(item.getId()).getName()).isEqualTo("new name");
        }
    }

    @Test
    void whenReplaceMissingItemThenReturnFalse() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item updatedItem = new Item("new name");
            boolean result = tracker.replace(999, updatedItem);
            assertThat(result).isFalse();
        }
    }

    @Test
    void whenDeleteItemThenTrackerDoesNotHaveItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test delete");
            tracker.add(item);
            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    void whenFindAllThenReturnAllItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            tracker.add(new Item("first"));
            tracker.add(new Item("second"));
            var result = tracker.findAll();
            assertThat(result)
                    .hasSize(2)
                    .extracting(Item::getName)
                    .containsExactlyInAnyOrder("first", "second");
        }
    }

    @Test
    void whenFindByNameThenReturnItemsWithSameName() throws Exception {
        try (var tracker = new HbmTracker()) {
            tracker.add(new Item("same"));
            tracker.add(new Item("same"));
            tracker.add(new Item("another"));
            var result = tracker.findByName("same");
            assertThat(result)
                    .hasSize(2)
                    .extracting(Item::getName)
                    .containsOnly("same");
        }
    }

    @Test
    void whenFindByIdThenReturnItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item("test");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getId()).isEqualTo(item.getId());
            assertThat(result.getName()).isEqualTo("test");
        }
    }

    @Test
    void whenFindByMissingIdThenReturnNull() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item result = tracker.findById(999);
            assertThat(result).isNull();
        }
    }

}