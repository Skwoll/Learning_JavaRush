package com.javarush.task.task06.task0609;

/* 
Расстояние между двумя точками
Требования:
1. Метод getDistance должен возвращать double.
2. Метод getDistance должен быть статическим.
3. Метод getDistance должен быть public.
4. Метод getDistance должен возвращать расстояние между точками.
5. Метод getDistance должен использовать метод double Math.sqrt(double a).
*/

public class Util {
    public static double getDistance(int x1, int y1, int x2, int y2) {
        //напишите тут ваш код
        return Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1),2));
    }

    public static void main(String[] args) {

    }
}
