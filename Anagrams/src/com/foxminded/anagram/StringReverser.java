package com.foxminded.anagram;

public class StringReverser {

    public String reverse(String input) {
        input = input.trim();

        if (input.equals("")) {
            return "";
        }

        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; ++i) {
            sb.append(reverseWord(words[i]) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private String reverseWord(String word) {
        char[] temp = word.toCharArray();
        int rightPointer = temp.length - 1;
        int leftPointer = 0;

        while (leftPointer < rightPointer) {
            if (!Character.isAlphabetic(temp[leftPointer])) {
                leftPointer++;
            } else if (!Character.isAlphabetic(temp[rightPointer])) {
                rightPointer--;
            } else {
                char letter = temp[leftPointer];
                temp[leftPointer] = temp[rightPointer];
                temp[rightPointer] = letter;
                leftPointer++;
                rightPointer--;
            }
        }

        return String.valueOf(temp);
    }
}
