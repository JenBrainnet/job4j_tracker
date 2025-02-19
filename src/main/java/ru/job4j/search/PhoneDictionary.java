package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, которые содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку
     */
    public ArrayList<Person> find(String key) {
        var searchPredicate = createPersonSearchPredicate(key);
        var result = new ArrayList<Person>();
        for (var currentPerson : persons) {
            if (searchPredicate.test(currentPerson)) {
                result.add(currentPerson);
            }
        }
        return result;
    }

    private Predicate<Person> createPersonSearchPredicate(String key) {
        Predicate<Person> namePredicate = p -> p.getName().contains(key);
        Predicate<Person> surnamePredicate = p -> p.getSurname().contains(key);
        Predicate<Person> phonePredicate = p -> p.getPhone().contains(key);
        Predicate<Person> addressPredicate = p -> p.getAddress().contains(key);
        return namePredicate.or(surnamePredicate).or(phonePredicate).or(addressPredicate);
    }

}
