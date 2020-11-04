package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipRemoveCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива");
        ZipFileManager fileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Ведите имя удаляемого файла");
        Path removingPath = Paths.get(ConsoleHelper.readString());
        fileManager.removeFile(removingPath);

        ConsoleHelper.writeMessage("Файл был удален");
    }
}
