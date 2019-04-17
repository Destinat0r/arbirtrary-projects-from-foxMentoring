package com.foxminded.integer_divisor;

import static org.junit.Assert.*;
import org.junit.Test;

import com.foxminded.integer_divisor.IntegerDivisor;

public class IntegerDivisionTest {
    
    private IntegerDivisor divisor = new IntegerDivisor();
    
    @Test
    public void shouldHandleOneByOneDivision() {
        assertEquals(" _1|1\n" +
                     "  1|-\n" +
                     "  -|1\n" +
                     "  0\n", divisor.divide(1,1) );
    }

    @Test
    public void shouldHandleZeroDivision() {
        assertEquals(" _0|5\n" +
                     "  0|-\n" +
                     "  -|0\n" +
                     "  0\n", divisor.divide(0,5));
    }
    
    @Test
    public void shouldHandleFiveDigitNumberDividedByOneDigit() {
        assertEquals(" _78945|4\n" +
                     "  4    |-----\n" +
                     "  -    |19736\n" +
                     " _38\n" +
                     "  36\n" +
                     "  --\n" +
                     "  _29\n" +
                     "   28\n" +
                     "   --\n" +
                     "   _14\n" +
                     "    12\n" +
                     "    --\n" +
                     "    _25\n" +
                     "     24\n" +
                     "     --\n" +
                     "      1\n", divisor.divide(78945,4));
    }
    
    @Test
    public void shouldHandleThreeByOneDigitsDivision() {
        assertEquals(" _945|6\n" +
                     "  6  |---\n" +
                     "  -  |157\n" +
                     " _34\n" +
                     "  30\n" +
                     "  --\n" +
                     "  _45\n" +
                     "   42\n" +
                     "   --\n" +
                     "    3\n", divisor.divide(945,6));    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenDivisionByZero() {
        divisor.divide(1, 0);
    }

    @Test
    public void shouldHandleOneByTwoDigitDivision() {
        assertEquals(" _5|45\n" +
                     "  0|-\n" +
                     "  -|0\n" +
                     "  5\n", divisor.divide(5,45));
    }

    @Test
    public void shouldHandleOneByThreeDigitDivision() {
        assertEquals(" _3|451\n" +
                     "  0|-\n" +
                     "  -|0\n" +
                     "  3\n", divisor.divide(3,451));
    }

    @Test
    public void shouldHandleFiveByTwoDigitDivision() {
        assertEquals(" _34525|45\n" +
                     "  315  |---\n" +
                     "  ---  |767\n" +
                     "  _302\n" +
                     "   270\n" +
                     "   ---\n" +
                     "   _325\n" +
                     "    315\n" +
                     "    ---\n" +
                     "     10\n", divisor.divide(34525,45));
    }
    
    @Test
    public void shouldHandleFourByTwoDigitDivision() {
        assertEquals(" _1234|77\n" +
                     "   77 |--\n" +
                     "   -- |16\n" +
                     "  _464\n" +
                     "   462\n" +
                     "   ---\n" +
                     "     2\n", divisor.divide(1234,77));
    }
}
