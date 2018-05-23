package com.javarush.task.task08.task0803;

import java.util.HashMap;
import java.util.Map;

/* 
Коллекция HashMap из котов
Требования:
1. Объяви переменную коллекции HashMap с типом элементов String, Cat и сразу проинициализируй ee.
2. Программа не должна считывать значения с клавиатуры.
3. Метод addCatsToMap() должен добавлять в коллекцию котов из массива String[] cats, согласно условию.
4. Программа должна выводить содержимое коллекции на экран, каждую пару через дефис и с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] cats = new String[]{"васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        HashMap<String, Cat> map = addCatsToMap(cats);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static HashMap<String, Cat> addCatsToMap(String[] cats) {
        //напишите тут ваш код
        HashMap<String, Cat> tmpmap = new HashMap<>();
        for (String s :
                cats) { tmpmap.put(s,new Cat(s));

        }
        return tmpmap;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
