package com.foxminded.anagram.tests;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import com.foxminded.anagram.StringReverser;

@RunWith(Parameterized.class)
public class StringReverserParamTest {

    private StringReverser reverser = new StringReverser();
    private String expected;
    private String input;

    public StringReverserParamTest(String expected, String input) {
        this.expected = expected;
        this.input = input;
    }

    @Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "fg5n 1Dbj 4mg", "ng5f 1jbD 4gm" },
                { "g1gf54h54 394gf", "h1fg54g54 394fg" },
                { ";fdbi04 fh93 93f5gh", ";ibdf04 hf93 93h5gf" },
                { "jnv894 794ffhg 57wg 3f4r", "vnj894 794ghff 57gw 3r4f" },
                { "ijfgvp 53g 34f asdf", "pvgfji 53g 34f fdsa" },
                { "g14ftrb jog4f mfdg53", "b14rtfg fgo4j gdfm53" },
                { "", "     " }});
    }

    @Test
    public void test() {
        assertEquals(expected, reverser.reverse(input));
    }
}
