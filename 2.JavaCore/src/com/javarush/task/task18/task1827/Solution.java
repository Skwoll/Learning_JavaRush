package com.javarush.task.task18.task1827;

/* 
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.

Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234


Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. В классе Solution не должны быть использованы статические переменные.
3. При запуске программы без параметров список товаров должен остаться неизменным.
4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
5. Товар должен иметь следующий id, после максимального, найденного в файле.
6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
7. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        if(args.length>0){
            if (args[0].equals("-c")){
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String fileName = bufferedReader.readLine();
                    TreeMap<Integer, String> base = new TreeMap<Integer, String>();
                    StringBuffer buffer;

                    try {
                        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                        while(fileReader.ready()){
                            buffer = new StringBuffer(fileReader.readLine());
                            base.put(Integer.parseInt(buffer.substring(0,8).trim()),buffer.substring(8,42));
                        }
                        fileReader.close();
                    } catch (FileNotFoundException e) {

                    }
                    int maxID = base.size() > 0 ? base.lastKey() + 1 : 0;

                    FileWriter fileWriter = new FileWriter(fileName,true);
                    if (maxID == 0){
                        fileWriter.append(String.format("%-8d%-30s%-8s%-4s",maxID,args[1],args[2],args[3]));
                    }
                    else{
                        fileWriter.append(String.format("%n%-8d%-30.30s%-8.8s%-4.4s",maxID,args[1],args[2],args[3]));

                    }
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
