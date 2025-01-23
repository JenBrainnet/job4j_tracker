package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringCompareTest {

    @Test
    void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenLeftIsEmptyAndRightIsNotResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenLeftIsNotEmptyAndRightIsResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                ""
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenLeftAndRightAreEmptyResultZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "",
                ""
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    void whenLeftHasLeadingSpaceResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                " Ivanov",
                "Ivanov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenRightHasLeadingSpaceResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                " Ivanov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenLeftHasSpecialSymbolsResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov!",
                "Ivanov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenLeftHasDigitsResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "I5anov",
                "Ivanov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    void whenLeftHasRussianLettersResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "АБВГД",
                "ABCDE"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    void whenLeftHasLettersInUpperCaseResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "IVANOV",
                "ivanov"
        );
        assertThat(result).isLessThan(0);
    }

}