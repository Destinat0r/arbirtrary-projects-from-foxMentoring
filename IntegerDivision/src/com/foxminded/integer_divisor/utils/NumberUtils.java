package com.foxminded.integer_divisor.utils;

public class NumberUtils {
     public static int findLength(int number) {
        return (number == 0) ? 1 : (int) (Math.log10(number) + 1);
    }
}
