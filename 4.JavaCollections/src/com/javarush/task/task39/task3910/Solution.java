package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPowerOfThree(int n) {
        if (Math.log((double)n)/Math.log(3.0) % 1.0 == 0) {
            return true;
        }
        return false;
    }
}
