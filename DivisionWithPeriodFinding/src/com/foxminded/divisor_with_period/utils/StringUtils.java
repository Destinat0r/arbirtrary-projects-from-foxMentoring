package com.foxminded.divisor_with_period.utils;

public class StringUtils {
    
    public static String makeRowOfSymbols(char symbol, int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; ++i) {
            sb.append(symbol);
        }
        return sb.toString();
    }
}
