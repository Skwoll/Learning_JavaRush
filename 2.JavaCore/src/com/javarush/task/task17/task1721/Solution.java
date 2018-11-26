package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            BufferedReader  reader =  new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            String removeFile =reader.readLine();

            BufferedReader fileReader = new BufferedReader( new FileReader(file));
            while (fileReader.ready()){
                allLines.add(fileReader.readLine());
            }

            BufferedReader removeFileReader = new BufferedReader(new FileReader(removeFile));
            while (removeFileReader.ready()){
                forRemoveLines.add(removeFileReader.readLine());
            }

            new Solution().joinData();

//            allLines.forEach(System.out::println);

            reader.close();
            fileReader.close();
            removeFileReader.close();

        } catch (CorruptedDataException e){

        } catch (IOException e) {


        }


    }

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
