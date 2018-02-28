package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
Требования:
1. В классе Solution создать public static класс Idea.
2. В классе Idea создать метод public String getDescription().
3. Метод getDescription должен возвращать любой непустой текст.
4. В классе Solution создайте метод public static void printIdea(Idea idea).
5. Метод printIdea должен выводить описание идеи на экран.
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }


    //напишите тут ваш код
    public static void printIdea(Idea idea){
        System.out.println(idea.getDescription());
    }
    public static class Idea{
        public String getDescription(){
            return "test";
        }
    }
}
