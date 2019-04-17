package com.foxminded.unique_chars_counter;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueCharsCounterTest {

    private UniqueCharsCounter counter = new UniqueCharsCounter();
    
    @Test
    public void shouldHandleStringFromExample() {
        String expected = "\"h\" - 1\n" +
                          "\"e\" - 1\n" +
                          "\"l\" - 3\n" +
                          "\"o\" - 2\n" +
                          "\" \" - 1\n" +
                          "\"w\" - 1\n" +
                          "\"r\" - 1\n" +
                          "\"d\" - 1\n" +
                          "\"!\" - 1\n";
        String actual = counter.countChars("hello world!");
        assertEquals(expected , actual);
    }
    
    @Test
    public void shouldGetAlreadyUsedStringFromCache() {
        String sameString = "hello world!";
        String caseOne = counter.countChars(sameString);
        String caseTwo = counter.countChars(sameString);
        assertSame(caseOne, caseTwo);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenInputNull() {
        counter.countChars(null);
    }
    
    @Test
    public void shouldHandleSingleSpace() {
        String expected = "\" \" - 1\n";
        String actual = counter.countChars(" ");
        assertEquals(expected, actual);
    }
    
    @Test
    public void shouldHandleStringWithNumbersOnly() {
        String expected = "\"3\" - 6\n" +
                          "\"4\" - 4\n" +
                          "\"2\" - 5\n" +
                          "\"9\" - 2\n" +
                          "\"8\" - 2\n" +
                          "\"7\" - 1\n" +
                          "\"5\" - 2\n" +
                          "\"6\" - 1\n" +
                          "\"1\" - 1\n";
        String actual = counter.countChars("342239982347568134235234");
        assertEquals(expected , actual);
    }
    
    @Test
    public void shouldHandleRowOfSingleSymbol() {
        String expected = "\"w\" - 24\n";
        String actual = counter.countChars("wwwwwwwwwwwwwwwwwwwwwwww");
        assertEquals(expected , actual);
    }
    
    @Test
    public void shouldHandleStringOfSpecialSymbols() {
        String expected = "\"&\" - 7\n" +
                          "\"^\" - 4\n" +
                          "\"*\" - 6\n" +
                          "\"@\" - 1\n" +
                          "\"#\" - 2\n" +
                          "\"!\" - 1\n" +
                          "\";\" - 1\n" +
                          "\"%\" - 9\n" +
                          "\"?\" - 1\n" +
                          "\"(\" - 6\n" +
                          "\")\" - 1\n" +
                          "\"$\" - 3\n" +
                          "\"_\" - 1\n";
        String actual = counter.countChars("&^&*@#!;%?()(*%%(*(%%%$*&%$%$&*^%^&#*(&^(&_");
        assertEquals(expected , actual);
    }

    @Test
    public void shouldHandleStringOfCyrilycSymbols() {
        String expected = "\"ж\" - 1\n" +
                          "\"д\" - 1\n" +
                          "\"ф\" - 2\n" +
                          "\"ы\" - 4\n" +
                          "\"а\" - 3\n" +
                          "\"л\" - 1\n" +
                          "\"о\" - 1\n" +
                          "\"в\" - 4\n" +
                          "\"т\" - 1\n" +
                          "\"м\" - 2\n" +
                          "\"г\" - 4\n" +
                          "\"у\" - 3\n" +
                          "\"ц\" - 3\n" +
                          "\"и\" - 1\n" +
                          "\"щ\" - 1\n" +
                          "\"ш\" - 1\n";
        String actual = counter.countChars("ждфыалоывтмгуцгуцгуцывавфымваигщш");
        assertEquals(expected , actual);
    }

    @Test
    public void shouldHandleStringOfJapaneseSymbols() {
        String expected = "\"ひ\" - 1\n" +
                          "\"ら\" - 1\n" +
                          "\"無\" - 2\n" +
                          "\"料\" - 2\n" +
                          "\"で\" - 2\n" +
                          "\"読\" - 1\n" +
                          "\"め\" - 1\n" +
                          "\"る\" - 1\n" +
                          "\"講\" - 1\n" +
                          "\"談\" - 1\n" +
                          "\"社\" - 1\n" +
                          "\"の\" - 1\n" +
                          "\"本\" - 1\n" +
                          "\" \" - 2\n" +
                          "\"「\" - 1\n" +
                          "\"ス\" - 1\n" +
                          "\"第\" - 1\n" +
                          "\"0\" - 1\n" +
                          "\"巻\" - 1\n" +
                          "\"が\" - 1\n" +
                          "\"な\" - 1\n";
        String actual = counter.countChars("ひら無料で読める講談社の本 「無料でス第0巻 がな");
        assertEquals(expected , actual);
    }
}
