package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SackTest {

    @Test
    void addTest_addToIntegerSack() {
        Sack<Integer> sack = new Sack<>();
        sack.add(1);
        sack.add(2);

        String expected = "Sack [1, 2]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTest_addToStringSack() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");

        String expected = "Sack [some string, another string]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void addTest_addToZeroSizedStringSack() {
        Sack<String> sack = new Sack<>(0);
        sack.add("some string");
        sack.add("another string");

        String expected = "Sack [some string, another string]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTest_removeFirstByIndex() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");
        sack.remove(0);

        String expected = "Sack [another string, third string]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTest_removeLastByIndex() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");
        sack.remove(2);

        String expected = "Sack [some string, another string]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTest_removeFromSackByIndex() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");
        sack.remove(1);

        String expected = "Sack [some string, third string]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void removeTest_removeLast() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");
        sack.removeLast();

        String expected = "Sack [some string, another string]";
        String actual = sack.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sizeTest_notEmpty() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");

        int expected = 3;
        int actual = sack.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sizeTest_allRemoved() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");
        sack.removeLast();
        sack.removeLast();
        sack.removeLast();

        int expected = 0;
        int actual = sack.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void sizeTest_empty() {
        Sack<String> sack = new Sack<>();

        int expected = 0;
        int actual = sack.size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getTest_getByIndex() {
        Sack<String> sack = new Sack<>();
        sack.add("some string");
        sack.add("another string");
        sack.add("third string");

        String expected = "another string";
        String actual = sack.get(1);
        Assertions.assertEquals(expected, actual);
    }
}
