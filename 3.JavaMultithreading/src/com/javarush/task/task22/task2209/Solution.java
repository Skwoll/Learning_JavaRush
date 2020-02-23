package com.javarush.task.task22.task2209;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            try (BufferedReader fr = new BufferedReader(new FileReader(new File(br.readLine())))){
                while (fr.ready()){
                    sb.append(" "+fr.readLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder result = getLine(sb.substring(1).split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>(Arrays.asList(words));
        list.removeIf(s -> s == null || s.isEmpty() || s.equals("")  );
        String s ="";
        StringBuilder sb = new StringBuilder();
        if (list.size()>0){
            s = list.get(0);
            sb.append(s);
            list.remove(s);
        }
        while (list.size()>0){
            String finalS = s.substring(s.length()-1).toUpperCase();
            s =  list.stream().filter(s1 -> s1.toUpperCase().startsWith(finalS)).findFirst().get();
            list.remove(s);
            sb.append( " "+s);

        }

        return sb;
    }
}
