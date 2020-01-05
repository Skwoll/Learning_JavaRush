package com.javarush.task.task39.task3909;

import org.junit.Test;

import static org.junit.Assert.*;

public class OneEdit {

    @Test
    public void isOneEditAway() {
        assertTrue("aaa aas",Solution.isOneEditAway("aaa","aas"));
        assertTrue("aaa aaa",Solution.isOneEditAway("aaa","aaa"));
        assertTrue("a ",Solution.isOneEditAway("a",""));
        assertTrue("a A",Solution.isOneEditAway("a","A"));
        assertTrue("as a",Solution.isOneEditAway("as","a"));
        assertTrue("assa dssa",Solution.isOneEditAway("assa","dssa"));
        assertTrue(" ",Solution.isOneEditAway("",""));
        assertTrue("aaa aaaa",Solution.isOneEditAway("aaa","aaaa"));
        assertTrue("aaaa aaa",Solution.isOneEditAway("aaaa","aaa"));
        assertFalse("as A",Solution.isOneEditAway("as","A"));

    }
}