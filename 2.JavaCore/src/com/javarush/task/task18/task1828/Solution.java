package com.javarush.task.task18.task1828;

/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD

Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id

Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        if(args.length>0){
            if (args[0].equals("-d")||args[0].equals("-u")) try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = bufferedReader.readLine();
                StringBuffer base = new StringBuffer();
                StringBuffer buffer;

                try {
                    BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                    while (fileReader.ready()) {
                        buffer = new StringBuffer(fileReader.readLine());
                        if (args[0].equals("-d") && args[1].equalsIgnoreCase(buffer.substring(0,8).trim())) {

                        } else if (args[0].equals("-u") && args[1].equalsIgnoreCase(buffer.substring(0,8).trim())){
                            base.append(buffer.substring(0,8)).append(String.format("%-30s%-8s%-4s", args[2], args[3], args[4])).append("\r\n");
                        }
                        else {
                            base.append(buffer).append("\r\n");
                        }

                    }
                    fileReader.close();
                } catch (FileNotFoundException e) {

                }
                base.replace(base.length()-2,base.length(),"");
                FileWriter fileWriter = new FileWriter(fileName);
                try {
                    fileWriter.append(base);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
