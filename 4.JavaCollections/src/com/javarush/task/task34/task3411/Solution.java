package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        switch (numRings) {
            case 1:
                System.out.println(String.format("from %s to %s",a,b));
                break;
            default:
                moveRing(a,c,b,numRings-1);
                System.out.println(String.format("from %s to %s",a,b));
                moveRing(c,b,a,numRings-1);
                break;
        }
    }
}