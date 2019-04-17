package com.foxminded.anagram.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.foxminded.anagram.StringReverser;

public class StringReverserTests {

    private StringReverser reverser = new StringReverser();

    @Test
    public void ShouldEmptyStringOnEmptyString() {
        assertEquals("Input: \"\"", "", reverser.reverse(""));
    }

    @Test
    public void ShouldEmptyStringOnSpaces() {
        assertEquals("Shoud return empty string on single space", "", reverser.reverse(" "));
        assertEquals("Shoud return empty string on any amount of spaces", "", reverser.reverse("           "));
    }

    @Test
    public void ShouldHandleUsualInput() {
        assertEquals("Incorrect output!", "fg5n 1Dbj 4mg", reverser.reverse("ng5f 1jbD 4gm"));
        assertEquals("Incorrect output!", "g1gf54h54 394gf", reverser.reverse("h1fg54g54 394fg"));
        assertEquals("Incorrect output!", ";fdbi04 fh93 93f5gh", reverser.reverse(";ibdf04 hf93 93h5gf"));
        assertEquals("Incorrect output!", "jnv894 794ffhg 57wg 3f4r", reverser.reverse("vnj894 794ghff 57gw 3r4f"));
        assertEquals("Incorrect output!", "ijfgvp 53g 34f asdf", reverser.reverse("pvgfji 53g 34f fdsa"));
        assertEquals("Incorrect output!", "g14ftrb jog4f mfdg53", reverser.reverse("b14rtfg fgo4j gdfm53"));
        assertEquals("Incorrect output!", "asda", reverser.reverse("adsa"));
    }

}