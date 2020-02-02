package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датами
Требования:
1. Если в метод printDate передана дата в формате "дата время", он должен вывести:
День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
2. Если в метод printDate передана дата в формате "дата", он должен вывести:
День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
3. Если в метод printDate передана дата в формате "время", он должен вывести:
AM или PM, Часы, Часы дня, Минуты, Секунды.
4. Используй статический метод getInstance класса Calendar для получения календаря.
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        boolean containsDate = false;
        boolean containsTime = false;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = null;
        if (date.contains(" ")){
            containsDate = true;
            containsTime = true;
            format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        } else if (date.contains(".")){
            containsDate = true;
            format = new SimpleDateFormat("dd.MM.yyyy");
        } else if (date.contains(":")){
            containsTime = true;
            format = new SimpleDateFormat("HH:mm:ss");
        }

        try {
            calendar.setTime(format.parse(date));
        } catch (Exception e) {
           return;
        }

        if (containsDate) {
            System.out.println("День: "+calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День недели: "+ (calendar.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK)-1 ));
            System.out.println("День месяца: "+calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: "+calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: "+calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: "+calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: "+(calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: "+calendar.get(Calendar.YEAR));
        }

        if(containsTime){
            System.out.println("AM или PM: "+calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH));
            System.out.println("Часы: "+calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: "+calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: "+calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: "+calendar.get(Calendar.SECOND));


        }
    }
}
