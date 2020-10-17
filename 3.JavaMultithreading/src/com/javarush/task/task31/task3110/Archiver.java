package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Scanner;

public class Archiver {
    public static void main(String[] args) {
        Operation operation;

        while (true) {
            try {
                operation = askOperation();
                if (operation == Operation.EXIT)
                    break;
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл." );
            } catch (Throwable e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }
//        Scanner scanner = new Scanner(new InputStreamReader(System.in));
//        System.out.println("Введите путь к архиву");
//        String archPath = scanner.nextLine();
//
//        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archPath));
//
//        System.out.println("Введите путь к архивируемому файлу");
//        String filePath = scanner.nextLine();
//
//        try {
//            zipFileManager.createZip(Paths.get(filePath));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            new ExitCommand().execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Выберите операцию:");
        for (Operation value : Operation.values()) {
            ConsoleHelper.writeMessage(String.format("%d - %s", value.ordinal(), value.getCommandDescription()));
        }
        return Operation.values()[ConsoleHelper.readInt()];
    }
}
