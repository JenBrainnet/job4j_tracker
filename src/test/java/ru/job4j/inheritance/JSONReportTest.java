package ru.job4j.inheritance;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class JSONReportTest {

    @Test
    void whenTestGenerateMethod() {
        String name = "Report's name";
        String body = "Report's body";
        String result = new JSONReport().generate(name, body);
        String ln = System.lineSeparator();
        String expected = "{" + ln
                + "\t\"name\" : \"Report's name\"," + ln
                + "\t\"body\" : \"Report's body\"" + ln
                + "}";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenNameIsDavidBodyIsNameSong() {
        String name = "David Gilmour";
        String body = "Shine On You Crazy Diamond";
        String result = new JSONReport().generate(name, body);
        String ln = System.lineSeparator();
        String expected = "{" + ln
                + "\t\"name\" : \"David Gilmour\"," + ln
                + "\t\"body\" : \"Shine On You Crazy Diamond\"" + ln
                + "}";
        assertThat(result).isEqualTo(expected);
    }

}