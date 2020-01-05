package com.javarush.task.task39.task3910;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    @Test
    public void isPowerOfThree() {
        assertTrue("3",Solution.isPowerOfThree(3));
        assertTrue("1",Solution.isPowerOfThree(1));
        assertTrue("27",Solution.isPowerOfThree(27));
        assertFalse("0",Solution.isPowerOfThree(0));
        assertFalse("7",Solution.isPowerOfThree(7));
        assertFalse("45",Solution.isPowerOfThree(45));
    }
}