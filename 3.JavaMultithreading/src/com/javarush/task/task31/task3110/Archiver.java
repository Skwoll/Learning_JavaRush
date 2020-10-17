package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Введите путь к архиву");
        String archPath = scanner.nextLine();

        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archPath));

        System.out.println("Введите путь к архивируемому файлу");
        String filePath = scanner.nextLine();

        try {
            zipFileManager.createZip(Paths.get(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            new ExitCommand().execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
