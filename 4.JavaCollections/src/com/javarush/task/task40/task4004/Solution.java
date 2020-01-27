package com.javarush.task.task40.task4004;

import java.util.ArrayList;
import java.util.List;

/* 
Принадлежность точки многоугольнику
Дан многоугольник, заданный координатами своих вершин.
Ребра многоугольника не пересекаются.
Необходимо реализовать метод isPointInPolygon(Point point, List<Point> polygon), который проверит, принадлежит ли переданная точка многоугольнику.
Для граничных точек принадлежность не определена: isPointInPolygon может вернуть как true так и false.
Метод main не изменяй.


Требования:
1. Метод isPointInPolygon должен вернуть true, если в него передать точку с координатами: 5, 5 и многоугольник, созданный в методе main.
2. Метод isPointInPolygon должен вернуть false, если в него передать точку с координатами: 100, 100 и многоугольник, созданный в методе main.
3. Программа должна вывести 2 строки: true и false.
4. Метод isPointInPolygon должен корректно работать для любых входных данных.
5. Метод main не изменяй.
*/

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Point> polygon = new ArrayList<>();
        polygon.add(new Point(0, 0));
        polygon.add(new Point(0, 10));
        polygon.add(new Point(10, 10));
        polygon.add(new Point(10, 0));

        System.out.println(isPointInPolygon(new Point(5, 5), polygon));
        System.out.println(isPointInPolygon(new Point(100, 100), polygon));
    }

    public static boolean isPointInPolygon(Point point, List<Point> polygon) {
        //напишите тут ваш код
        Point last = polygon.get(polygon.size()-1);

        boolean result = false;
        for (Point p :
                polygon) {
            if ((last.y < p.y && last.y <= point.y && point.y <= p.y && (p.y - last.y) * (point.x - last.x) > (p.x - last.x) * (point.y - last.y))
                    || (last.y > p.y && last.y >= point.y && point.y >= p.y && (p.y - last.y) * (point.x - last.x) < (p.x - last.x) * (point.y - last.y))) {

                result = !result;
            }
            last = p;
        }
        return result;
    }

}

