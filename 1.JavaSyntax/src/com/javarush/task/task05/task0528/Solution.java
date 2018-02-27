package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
Требования:
1. Дата должна содержать день, месяц и год, разделенные пробелом.
2. День должен соответствовать текущему.
3. Месяц должен соответствовать текущему.
4. Год должен соответствовать текущему.
5. Вся дата должна быть выведена в одной строке.
*/

import sun.util.calendar.BaseCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Calendar date = new GregorianCalendar();

        System.out.println(date.get(Calendar.DAY_OF_MONTH)+" "+(date.get(Calendar.MONTH)+1)+" "+date.get(Calendar.YEAR));
    }
}
