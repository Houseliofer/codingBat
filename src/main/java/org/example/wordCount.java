package org.example;

import org.jetbrains.annotations.NotNull;

public class wordCount {
    public int wordsCount(@NotNull String[] words, int len) {
        int count = 0;
        for (int i = 0; i<words.length; i++){
            if (words[i].length() == len)
                count++;
        }return count;
    }
}
