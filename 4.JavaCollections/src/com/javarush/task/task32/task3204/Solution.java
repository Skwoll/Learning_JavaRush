package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Random rnd = new Random();

        boolean number = true;
        boolean upperCase = true;
        boolean lowerCase = true;
        int passwodrLength = 8;

        do {
            number = upperCase = lowerCase = true;
            baos.reset();
            for (int i = 0; i < passwodrLength; i++) {
                int nextType = rnd.nextInt(3);

                switch (nextType) {
                    case 0:
                        baos.write(48 + rnd.nextInt(9));
                        number = false;
                        break;
                    case 1:
                        baos.write(65 + rnd.nextInt(25));
                        upperCase = false;
                        break;
                    case 2:
                        baos.write(97 + rnd.nextInt(25));
                        lowerCase = false;
                        break;
                    default:
                        break;

                }

            }
        } while (number || upperCase || lowerCase);

        return baos;
    }
}