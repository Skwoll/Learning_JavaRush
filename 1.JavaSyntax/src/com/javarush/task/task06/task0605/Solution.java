package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
Требования:
1. Метод massIndex должен выводить текст на экран.
2. Метод massIndex должен выводить "Недовес: меньше чем 18.5" на экран, если индекс массы тела меньше 18.5.
3. Метод massIndex должен выводить "Нормальный: между 18.5 и 24.9" на экран, если индекс массы тела между 18.5 и 24.9.
4. Метод massIndex должен выводить "Избыточный вес: между 25 и 29.9" на экран, если индекс массы тела между 25 и 29.9.
5. Метод massIndex должен выводить "Ожирение: 30 или больше" на экран, если индекс массы тела 30 или больше.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            double index = weight / (height * height);
            String result = "";
            if (index < 18.5) {
                result = "Недовес: меньше чем 18.5";
            }else if (index >=18.5 & index <= 24.9){
                result = "Нормальный: между 18.5 и 24.9";
            }else if (index >= 25 & index <=29.9){
                result = "Избыточный вес: между 25 и 29.9";
            }else{
                result = "Ожирение: 30 или больше";
            }

            System.out.println(result);


            //напишите тут ваш код
        }
    }
}
