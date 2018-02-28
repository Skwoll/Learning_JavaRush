package com.javarush.task.task06.task0616;

/* 
Минимальное число статиков
Требования:
1. Реализацию и модификаторы доступа методов менять нельзя.
2. Добавь модификаторы static в нужные места.
3. В программе должно быть только 4 модификатора static.
4. Программа должна выводить текст на экран.
*/

public class Solution {
    static public int step;

    public static void main(String[] args) {
        method1();
    }

    static public void method1() {
        method2();
    }

    static public void method2() {
        new Solution().method3();
    }

    public void method3() {
        method4();
    }

    public void method4() {
        step++;
        for (StackTraceElement element : Thread.currentThread().getStackTrace())
            System.out.println(element);
        if (step > 1)
            return;
        main(null);
    }
}
