package com.javarush.task.task08.task0827;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Date.*;

/* 
Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате FEBRUARY 1 2013
Не забудьте учесть первый день года.

Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false


Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date t = null;
        Date t2 = null;
        SimpleDateFormat df = new SimpleDateFormat("MMM dd yyyy");

        try {
            t = df.parse(date);
            t2 = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        t.setDate(1);
        t.setMonth(0);

        long ddif = t2.getTime() - t.getTime();
        int days = (int) (ddif / (24 * 60 * 60 * 1000));
        return (days % 2) > 0 ? false : true;
    }
}
