package com.javarush.task.task31.task3110;

import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ConsoleHelper {
    private static Scanner scanner = new Scanner(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() {
        while (true) {
            try {
                return scanner.nextLine();
            } catch (IllegalStateException e) {
                System.out.println("С программой что-то не то :'(");
                e.printStackTrace();
                System.exit(0);
            } catch (NoSuchElementException e) {
                //ничего не делам, ждем повтороного воода
            }
        }
    }

    public static int readInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (IllegalStateException e) {
                System.out.println("С программой что-то не то :'(");
                e.printStackTrace();
                System.exit(0);
            } catch (InputMismatchException e) {
                System.out.println(String.format("Значение должно входить в диапазон %D %D", Integer.MIN_VALUE, Integer.MAX_VALUE) );
            } catch (NoSuchElementException e) {
                //ничего не делам, ждем повтороного воода
            }
        }
    }

}
