package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {//если длина отличается больше чем на 1 символ, то одним изменением не отделаться
            return false;
        }
        if (first.isEmpty()||second.isEmpty())//если одна из строк пустая
            return true;
        if(first.equals(second)) //если строки равны
            return true;

        boolean firstIsLongest = first.length()>=second.length();

        for (int i = 0; i < (firstIsLongest ? second.length(): first.length()) ; i++) {
           if (first.charAt(i)!= second.charAt(i)){//если символы не равны то делаем только одно именение и его результат выводим
               return firstIsLongest && second.equals(first.substring(0,i).concat(first.substring(i+1)))//если первая длинней, удалим текущий символ из неё
                     || !firstIsLongest && first.equals(second.substring(0,i).concat(second.substring(i+1)))//если втора длиней то из второй
                     || first.equals(second.substring(0,i)+first.charAt(i)+second.substring(i+1));//если строки равны то во второй заменим отличающийся символ
           }
        }
        return true;
    }
}
