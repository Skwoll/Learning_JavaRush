package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
В процессе разработки новой версии популярного графического редактора возникла необходимость реализовать заливку области
картинки определенным цветом.

Реализуй метод paintFill в классе PhotoPaint таким образом, чтобы он возвращал:
- false, если цвет начальной точки (координаты приходят в качестве параметров) совпадает с цветом заливки
или если начальные координаты выходят за рамки массива.
- модифицировал входящий массив и возвращал true, если заливка все же может быть выполнена.

Точке с координатами (x, y) соответствует элемент массив с индексом [y][x].

P.S. Если алгоритм работы заливки не очевиден, можешь попрактиковаться в графическом редакторе Paint.


Требования:
1. Метод paintFill должен возвращать false, если переданные координаты выходят за границы изображения.
2. Метод paintFill должен возвращать false, если цвет начальной точки совпадает с цветом заливки.
3. Метод paintFill должен возвращать true и корректно модифицировать изображение, если это возможно.
4. Метод paintFill должен быть публичным.
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Color[][] image = {{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.GREEN,Color.GREEN},{Color.GREEN,Color.YELLOW,Color.GREEN}};
        boolean result =  new PhotoPaint().paintFill(image,0,0,Color.BLUE);

        System.out.println(result);
        for (Color[] colors : image) {
            System.out.println(Arrays.toString(colors));
        }
    }
}
