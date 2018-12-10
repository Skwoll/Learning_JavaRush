package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileIn = bufferedReader.readLine();
            String fileOut = bufferedReader.readLine();

            FileOutputStream fileOutputStream = new FileOutputStream(fileOut);
            FileReader fileReader = new FileReader(fileIn);
            BufferedReader lineReade = new BufferedReader(fileReader);
            String tmp;

            while ((tmp = lineReade.readLine()) != null){
                for (String s : tmp.split(" ")) {
//                    System.out.println(Math.round(Double.parseDouble(s)));

                    fileOutputStream.write((String.valueOf(Math.round(Double.parseDouble(s)))+" ").getBytes());
                }

            }
            fileReader.close();
            lineReade.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {

        }

    }
}
