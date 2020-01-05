package com.javarush.task.task39.task3908;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalinrdomeTest {

    @Test
    public void isPalindromePermutation() {
        assertTrue("aassddff", Solution.isPalindromePermutation("aassddff"));
        assertTrue("AasSddff", Solution.isPalindromePermutation("AasSddff"));
        assertTrue("AasSdddff", Solution.isPalindromePermutation("AasSdddff"));
        assertFalse("AasSdddf", Solution.isPalindromePermutation("AasSdddf"));
        assertFalse("as", Solution.isPalindromePermutation("as"));
        assertFalse("aaasss", Solution.isPalindromePermutation("aaasss"));
    }
}