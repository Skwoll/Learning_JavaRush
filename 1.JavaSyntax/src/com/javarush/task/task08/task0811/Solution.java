package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
Требования:
1. Программа не должна выводить текст на экран.
2. Класс Solution должен содержать только 5 методов.
3. Метод getListForGet должен возвращать список, который лучше всего подходит для операции взятия элемента.
4. Метод getListForSet должен возвращать список, который лучше всего подходит для установки значения элемента.
5. Метод getListForAddOrInsert должен возвращать список, который лучше всего подходит для операций добавления или вставки элемента.
6. Метод getListForRemove должен возвращать список, который лучше всего подходит для операции удаления элемента.
*/

public class Solution {
    public static List getListForGet() {
        //напишите тут ваш код
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, new Object());
            linkedList.add(0, new Object());

        }

        Date startTimeLL = new Date();

        for (int i = 0 ; i<10000;i++) {
            linkedList.get(i);
        }
        Date endTimeLL = new Date();

        Date startTimeAL = new Date();

        for (int i = 0 ; i<10000;i++) {
            arrayList.get(i);
        }
        Date endTimeAL = new Date();

        if (endTimeAL.getTime()-startTimeAL.getTime() > endTimeLL.getTime()-startTimeLL.getTime())
            return linkedList;
        else return arrayList;
    }

    public static List getListForSet() {
        //напишите тут ваш код
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, new Object());
            linkedList.add(0, new Object());

        }
        Date startTimeLL = new Date();

        for (int i = 0 ; i<10000;i++) {
            linkedList.set(i,i);
        }
        Date endTimeLL = new Date();

        Date startTimeAL = new Date();

        for (int i = 0 ; i<10000;i++) {
            arrayList.set(i,i);
        }
        Date endTimeAL = new Date();

        if (endTimeAL.getTime()-startTimeAL.getTime() > endTimeLL.getTime()-startTimeLL.getTime())
            return linkedList;
        else return arrayList;

    }

    public static List getListForAddOrInsert() {
        //напишите тут ваш код
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();



        Date startTimeLL = new Date();

        for (int i = 0 ; i<10000;i++) {
            linkedList.add(0, new Object());
        }
        Date endTimeLL = new Date();

        Date startTimeAL = new Date();

        for (int i = 0 ; i<10000;i++) {
            arrayList.add(0, new Object());
        }
        Date endTimeAL = new Date();

        if (endTimeAL.getTime()-startTimeAL.getTime() > endTimeLL.getTime()-startTimeLL.getTime())
            return linkedList;
        else return arrayList;
    }



    public static List getListForRemove() {
        //напишите тут ваш код
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, new Object());
            linkedList.add(0, new Object());

        }
        Date startTimeLL = new Date();

        for (int i = 0 ; i<10000;i++) {
            linkedList.remove(0);
        }
        Date endTimeLL = new Date();

        Date startTimeAL = new Date();

        for (int i = 0 ; i<10000;i++) {
            arrayList.remove(0);
        }
        Date endTimeAL = new Date();

        if (endTimeAL.getTime()-startTimeAL.getTime() > endTimeLL.getTime()-startTimeLL.getTime())
            return linkedList;
        else return arrayList;

    }

    public static void main(String[] args) {

    }
}
