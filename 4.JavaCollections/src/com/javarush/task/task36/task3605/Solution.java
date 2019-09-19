package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
            TreeSet<String> result = new TreeSet<>();

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                   result.add(matcher.group().toLowerCase());
                }

            }
            String[] resultArray = result.toArray(new String[0]);
            int len = resultArray.length>5 ? 5 : resultArray.length;
            for (int i = 0; i < len; i++) {
                System.out.print(resultArray[i]);
            }
        }

    }
}
