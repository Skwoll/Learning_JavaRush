package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...

В общем, мне нужен метод romanToInteger, который будет конвертировать число в римской системе счисления {I, V, X, L, C, D, M} в десятичную. Иначе никак не разобрать что и когда у них происходило.


Требования:
1. Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
2. Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
3. Метод romanToInteger должен быть публичным.
4. Метод romanToInteger должен быть статическим.
*/
public class Solution {
    private static Map<Character,Integer> pairs = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    private static void fillPairs(){
        pairs.clear();
        pairs.put('I',1);
        pairs.put('V',5);
        pairs.put('X',10);
        pairs.put('L',50);
        pairs.put('C',100);
        pairs.put('D',500);
        pairs.put('M',1000);



    }
    public static int romanToInteger(String s) {
        fillPairs();
        int result =0;
        int curval;
        int lastval = 0;
        for (char c : s.toUpperCase().toCharArray()) {
           curval = pairs.get(c);
           if (curval > lastval){
               result-=lastval;
               result+=curval-lastval;
           }
           else {
               result+=curval;
           }
            lastval = curval;
        }
        return result;
    }
}
