package ru.job4j.search;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var foundPersons = phoneDictionary.find("Petr");
        assertThat(foundPersons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindWithNoMatchThenEmptyList() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var foundPersons = phoneDictionary.find("Moscow");
        assertThat(foundPersons).isEmpty();
    }

}