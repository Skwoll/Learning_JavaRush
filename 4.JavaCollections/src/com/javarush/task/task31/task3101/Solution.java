package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
2.2. Переименовать resultFileAbsolutePath в 'allFilesContent.txt' (используй метод FileUtils.renameFile, и, если понадобится, FileUtils.isExist).
2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2){
            return;
        }
        File sourceFile = new File(args[1]);
        File outFile = new File(sourceFile.getParent()+"/allFilesContent.txt");
        List<File> files;

        files = Files.find(Paths.get(args[0]), Integer.MAX_VALUE, (p, bfa) -> bfa.isRegularFile()
                && bfa.size() <=50).sorted(Comparator.comparing(Path::getFileName)).map(Path::toFile)
                .collect(Collectors.toList());

        if (FileUtils.isExist(outFile)){
            FileUtils.deleteFile(outFile);
            FileUtils.renameFile(sourceFile, outFile );
        }

        FileWriter fileWriter = new FileWriter(outFile,true);
        for (File f: files
             ) {
            FileReader fileReader = new FileReader(f);
            char[] buffer = new char[100];
            int cnt = fileReader.read(buffer);
            if(cnt>0) {
                fileWriter.write(buffer, 0, cnt - 1);
            }
            fileWriter.write("\n");
            fileWriter.flush();
            fileReader.close();
        }
        fileWriter.close();







    }
}
