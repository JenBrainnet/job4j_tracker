package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new StubOutput();
        Input input = new MockInput(
                List.of("0", "Item name", "1")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Output output = new StubOutput();
        Input input = new MockInput(
                List.of("0", String.valueOf(item.getId()), replacedName, "1")
        );
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    void whenDeleteItem() {
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output output = new StubOutput();
        Input input = new MockInput(
                List.of("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new DeleteAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                List.of("0")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo(
                "Меню:" + System.lineSeparator()
                        + "0. Завершить программу" + System.lineSeparator()
                        + "=== Завершение программы ===" + System.lineSeparator()
        );
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                List.of("0", String.valueOf(one.getId()), replaceName, "1")
        );
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item one = tracker.add(new Item("Item one"));
        Item two = tracker.add(new Item("Item two"));
        Input input = new MockInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(
                new FindAllAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Input input = new MockInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(
                new FindAllAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище еще не содержит заявок." + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        String name = "Item name";
        Item one = tracker.add(new Item(name));
        Item two = tracker.add(new Item(name));
        Input input = new MockInput(
                List.of("0", name, "1")
        );
        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item name"));
        String anotherName = "Another item name";
        Input input = new MockInput(
                List.of("0", anotherName, "1")
        );
        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: " + anotherName + " не найдены." + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Item name"));
        Input input = new MockInput(
                List.of("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new FindByIdAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdTestOutputIsNotSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Item name"));
        Input input = new MockInput(
                List.of("0", "1000", "1")
        );
        List<UserAction> actions = List.of(
                new FindByIdAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: 1000 не найдена." + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(
                List.of("1", "0")
        );
        Store tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "Неверный ввод, вы можете выбрать: 0 .. 0" + ln
                        + "Меню:" + ln
                        + "0. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    public void whenItemWasReplacedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
        );
    }

    @Test
    public void whenItemWasNotReplaced() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        ReplaceAction replaceAction = new ReplaceAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(100);
        when(input.askStr(any(String.class))).thenReturn("New item name");
        replaceAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Редактирование заявки ===" + ln
                        + "Ошибка замены заявки." + ln
        );
    }

    @Test
    void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                + "Заявка удалена успешно." + ln
        );
    }

    @Test
    void whenItemWasNotDeleted() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(100);
        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Удаление заявки ===" + ln
                        + "Ошибка удаления заявки" + ln
        );
    }

    @Test
    void whenItemWasFoundById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(item.getId());
        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + item + ln
        );
    }

    @Test
    void whenItemWasNotFoundById() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        FindByIdAction findByIdAction = new FindByIdAction(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(100);
        findByIdAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявки по id ===" + ln
                        + "Заявка с введенным id: 100 не найдена." + ln
        );
    }

    @Test
    void whenItemsWereFoundByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        String name = "Item name";
        Item item1 = tracker.add(new Item(name));
        Item item2 = tracker.add(new Item(name));
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ===" + ln
                        + item1 + ln
                        + item2 + ln
        );
    }

    @Test
    void whenItemsWereNotFoundByName() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        String name = "Item name";
        FindByNameAction findByNameAction = new FindByNameAction(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        findByNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Вывод заявок по имени ===" + ln
                        + "Заявки с именем: " + name + " не найдены." + ln
        );
    }

}