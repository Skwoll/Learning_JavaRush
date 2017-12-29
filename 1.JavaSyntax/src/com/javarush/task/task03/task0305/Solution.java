package com.javarush.task.task03.task0305;

/* 
Я так давно родился
*/

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        GregorianCalendar d = new GregorianCalendar(1986, Calendar.APRIL, 22);


        System.out.print(d.getDisplayName(Calendar.MONTH,Calendar.LONG, Locale.US).toUpperCase()+ " ");
        System.out.print(d.get(Calendar.DATE)+ " ");
        System.out.println(d.get(Calendar.YEAR));
    }
}
