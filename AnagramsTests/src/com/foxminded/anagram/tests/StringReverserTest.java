package com.foxminded.anagram.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.foxminded.anagram.StringReverser;

public class StringReverserTest {

    private StringReverser reverser = new StringReverser();

    @Test
    public void shouldWorkWithSameLettersOnly() {
        assertEquals("ccc", reverser.reverse("ccc"));
    }

    @Test
    public void shouldWorkWithWordsOfLettersOnly() {
        assertEquals("abcd efgh", reverser.reverse("dcba hgfe"));
    }

    @Test
    public void shouldReturnInputWhenRowOfNumbers() {
        assertEquals("111", reverser.reverse("111"));
    }

    @Test
    public void shouldReturnInputWhenFewRowsOfNumbers() {
        assertEquals("123 456", reverser.reverse("123 456"));
    }

    @Test
    public void shouldReverseOnlyLettersWhenSingleWord() {
        assertEquals("g3nt1st", reverser.reverse("t3st1ng"));
    }

    @Test
    public void shouldReverseOnlyLettersWhenMoreThanOneWord() {
        assertEquals("t3st nv1r3d t3n3m0pl3vd", reverser.reverse("t3st dr1v3n d3v3l0pm3nt"));
    }

    @Test
    public void shouldReturnEmptyStringWhenEmptyString() {
        assertEquals("", reverser.reverse(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNull() {
        reverser.reverse(null);
    }

    @Test
    public void shouldReturnEmptyStringWhenSpace() {
        assertEquals("", reverser.reverse(" "));
    }
}
