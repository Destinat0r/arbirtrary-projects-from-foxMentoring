package com.foxminded.integer_divisor.utils;

import java.util.Arrays;

public class StringUtils {
    
    public static String makeRowOfSymbols(char symbol, int num) {
        char[] arr = new char[num];
        Arrays.fill(arr, symbol);
        return new String(arr);
    }
}
