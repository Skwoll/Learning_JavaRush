package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
Реализуй метод downloadFile(String urlString, Path downloadDirectory), на вход которого подается ссылка для скачивания файла и папка, куда нужно закачать файл.
Все ссылки имеют вид:
https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
http://toogle.com/files/rules.txt
https://pacemook.com/photos/image1.jpg

Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
Используй только классы и методы из пакета java.nio.


Требования:
1. Метод downloadFile должен создавать объект URL для переданной ссылки.
2. Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile.
3. Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy.
4. Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move.
5. Имя сохраненного файла должно быть таким же, как в URL-ссылке.
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));
//        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("c:/tmp/out"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        System.out.println(urlString.split(".+/",2)[1]);
        Path tmpPath = Files.createTempFile("tmp-", ".tmp");
        Files.copy(inputStream, tmpPath, StandardCopyOption.REPLACE_EXISTING);
        Path file = downloadDirectory.resolve(Paths.get(url.getFile()).getFileName());

        Files.move(tmpPath, file, StandardCopyOption.REPLACE_EXISTING);
        return file;
    }
}
