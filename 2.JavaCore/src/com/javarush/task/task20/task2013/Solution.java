package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
Класс Person должен сериализовываться с помощью интерфейса Externalizable.
Исправь ошибку сериализации.
Сигнатуры методов менять нельзя.


Требования:
1. В классе Solution.Person должен быть создан публичный конструктор без параметров.
2. В классе Solution.Person должен быть создан конструктор с тремя параметрами (String firstName, String lastName, int age).
3. Класс Solution.Person должен поддерживать интерфейс Externalizable.
4. Методы readExternal и writeExternal должны позволять корректно сериализовывать и десериализовывать объекты типа Person.
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public  Person (){
            super();
        }
        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args)throws IOException,ClassNotFoundException {
        Person person = new Person("Ivan","Ivanov",40);
        person.setFather(new Person("Petr", "Ivanov",65));
        person.setMother(new Person("Irina","Ivanova",65));
        person.setChildren(Arrays.asList(new Person("Dmitrij", "Ivanov", 10), new Person("Anna","Ivanova",10)));
        person.father.setChildren(Arrays.asList(person));
        person.mother.setChildren(Arrays.asList(person));

        ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("c:\\tmp\\task2013.dat"));
        ou.writeObject(person);
        ou.flush();
        ou.close();

        ObjectInputStream iu = new ObjectInputStream(new FileInputStream("c:\\tmp\\task2013.dat"));
        Person loadedPerson = (Person) iu.readObject();
        System.out.println(loadedPerson);


    }
}
