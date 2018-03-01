package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
Требования:
1. Программа должна считывать имена 6 котов в указанном порядке.
2. Метод main должен создавать 6 объектов типа Cat.
3. Программа должна выводить 6 строк с информацией о котах.
4. Строка про дедушку (первая) должна соответствовать условию.
5. Строка про бабушку (вторая) должна соответствовать условию.
6. Строка про папу (третья) должна соответствовать условию.
7. Строка про маму (четвертая) должна соответствовать условию.
8. Строка про сына (пятая) должна соответствовать условию.
9. Строка про дочь (шестая) должна соответствовать условию.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grentFatherName = reader.readLine();
        Cat catGrentFather = new Cat(grentFatherName);

        String grentMotherName = reader.readLine();
        Cat catGrentMother = new Cat(grentMotherName);

        String fatehrName = reader.readLine();
        Cat catfather = new Cat(fatehrName, catGrentFather,null);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, null, catGrentMother);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catfather, catMother);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catfather, catMother);

        System.out.println(catGrentFather);
        System.out.println(catGrentMother);
        System.out.println(catfather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            /*if (parent == null)
                return "Cat name is " + name + ", no mother ";
            else
                return "Cat name is " + name + ", mother is " + parent.name;*/
            return "Cat name is " + name + (mother == null ? ", no mother" : ", mother is "+ mother.name) + (father == null ? ", no father" : ", father is "+ father.name);
        }
    }

}
