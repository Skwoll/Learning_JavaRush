package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = bufferedReader.readLine();
            while (!fileName.toUpperCase().equals("EXIT")){
                new ReadThread(fileName).start();
                fileName = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        resultMap.forEach((s, integer) -> {System.out.println(s+ " "+integer);});


    }

    public static class ReadThread extends Thread {
        private Map<String, Integer> fileMap = new HashMap<>();
        private FileInputStream fileInputStream;
        private  String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            try {
                fileInputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                while (fileInputStream.available() > 0) {
                    Integer tmp = fileInputStream.read();
                    if (fileMap.containsKey(tmp.toString())) {
                        fileMap.put(tmp.toString(), fileMap.get(tmp.toString()) + 1);
                    } else {
                        fileMap.put(tmp.toString(), 1);
                    }
                }
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int maxKey = Integer.parseInt(Collections.max(fileMap.entrySet(), Map.Entry.comparingByValue()).getKey());

            synchronized (resultMap){

                resultMap.put(fileName,maxKey);
            }
        }
    }
}
