package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
Реализуй интерфейс Externalizable в классе Apartment.


Требования:
1. Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
2. В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
3. В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
4. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
5. В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
6. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
7. Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address =(String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException {
        Apartment apt = new Apartment("Addres st.", 2019);
        ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream("c:\\tmp\\task2011.dat"));
        ou.writeObject(apt);
        ou.close();
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("c:\\tmp\\task2011.dat"));
        Apartment reApt = (Apartment) oi.readObject();
        System.out.println(reApt.toString());
        oi.close();
    }
}