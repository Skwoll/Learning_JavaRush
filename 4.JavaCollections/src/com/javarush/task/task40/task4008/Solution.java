package com.javarush.task.task40.task4008;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
Выполни задание, используя Java 8 DateTime API.
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответствии с примером:

1) Для "9.10.2017 5:56:45" вывод должен быть:
День: 9
День недели: 1
День месяца: 9
День года: 282
Неделя месяца: 3
Неделя года: 42
Месяц: 10
Год: 2017
AM или PM: PM
Часы: 5
Часы дня: 5
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014

3) Для "17:33:40":
AM или PM: PM
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40


Требования:
1. Если в метод printDate передана дата в формате "дата время", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
2. Если в метод printDate передана дата в формате "дата", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
3. Если в метод printDate передана дата в формате "время", он должен вывести: AM или PM, Часы, Часы дня, Минуты, Секунды.
4. Используй статический метод parse классов LocalDate и LocalTime.
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
        LocalDate datePart = null;
        LocalTime timePart = null;
        String[] parts = date.split(" ");
        try {
            datePart = LocalDate.parse(parts[0], DateTimeFormatter.ofPattern("d.M.yyyy"));
        } catch (Exception e) {
        }
        try {
            timePart = LocalTime.parse(parts[parts.length-1],DateTimeFormatter.ofPattern("H:m:s"));
        } catch (Exception e) {
        }
        if(datePart != null){
            System.out.println("День: "+datePart.getDayOfMonth() );
            System.out.println("День недели: "+ datePart.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: "+datePart.getDayOfMonth());
            System.out.println("День года: "+datePart.getDayOfYear());
            System.out.println("Неделя месяца: "+(datePart.get(ChronoField.ALIGNED_WEEK_OF_MONTH)));
            System.out.println("Неделя года: "+(datePart.get(ChronoField.ALIGNED_WEEK_OF_YEAR)));
            System.out.println("Месяц: "+datePart.getMonthValue());
            System.out.println("Год: "+datePart.getYear());
        }
        if (timePart != null){
            System.out.println("AM или PM: " + (timePart.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
            System.out.println("Часы: "+timePart.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: "+timePart.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: "+timePart.getMinute());
            System.out.println("Секунды: "+timePart.getSecond());
        }
    }
}
