package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        ArrayList<String> tmpStr = new ArrayList<>();
        ArrayList<Integer> tmpNum = new ArrayList<>();
        ArrayList<Integer> indexStr = new ArrayList<>();
        ArrayList<Integer> indexNum = new ArrayList<>();
        for (int i = 0; i < array.length ; i++) {
            if (isNumber(array[i])){
                tmpNum.add(Integer.parseInt(array[i]));
                indexNum.add(i);
            } else {
                tmpStr.add(array[i]);
                indexStr.add(i);
            }
        }
        for (int i = 0; i < tmpStr.size(); i++) {
            for (int j = 1; j < tmpStr.size()-i; j++) {
                if (isGreaterThan(tmpStr.get(j-1),tmpStr.get(j))){
                    String s = tmpStr.get(j - 1);
                    tmpStr.set(j-1, tmpStr.get(j));
                    tmpStr.set(j, s);
                }
            }
        }
        tmpNum.sort((o1, o2) -> o2.compareTo(o1));

        for (int i = 0; i < tmpNum.size(); i++) {
            array[indexNum.get(i)] = tmpNum.get(i).toString();
        }
        for (int i = 0; i < tmpStr.size(); i++) {
            array[indexStr.get(i)] = tmpStr.get(i);
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        return true;
    }
}
