package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import static org.example.wordCount.wordsCount;

public class wordCountTest extends TestCase {
    String arr[];

    public void setArr() {
        arr = new String[4];
        this.arr[0] = "a";
        this.arr[1] = "bb";
        this.arr[2] = "b";
        this.arr[3] = "ccc";
    }

    @Test
    public void cuando_length_es_uno(){
        setArr();
        assertEquals(2, wordsCount(this.arr,1));
    }
    @Test
    public void cuando_length_es_tres(){
        setArr();
        assertEquals(1, wordsCount(this.arr,3));
    }
    @Test
    public void cuando_length_es_cuatro(){
        setArr();
        assertEquals(0, wordsCount(this.arr,4));
    }
}