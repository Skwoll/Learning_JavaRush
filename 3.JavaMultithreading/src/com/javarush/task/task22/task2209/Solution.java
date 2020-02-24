package com.javarush.task.task22.task2209;


import java.io.*;
import java.util.*;

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
        final StringBuilder sb = new StringBuilder();
        if (words != null && words.length>0)
        {
            List<String> list = new LinkedList<>(Arrays.asList(words));
            list.removeIf(s -> s == null || s.isEmpty() || s.equals("")  );
            list.forEach(s -> sb.append(" "+s));
            sb.replace(0, 1, "");
            List<StringBuilder> outList = new LinkedList<>();

            for (String s : list) {
                List<String> workList = new LinkedList<>(list);
                StringBuilder currentSB = new StringBuilder();
                currentSB.append(s);
                workList.remove(s);

                while(!workList.isEmpty()){
                    String finalS = currentSB.substring(currentSB.length()-1).toUpperCase();
                    try {
                        String st = workList.stream().filter(s1 -> s1.toUpperCase().startsWith(finalS)).findFirst().get();

                        currentSB.append(" "+ st);
                        workList.remove(st);
                    } catch (Exception e) {
                        break;
                    }
                }
                outList.add(currentSB);

            }
            outList.sort(Comparator.comparingInt(o -> o.length()));
            if (outList.get(outList.size()-1).length() == sb.length()){
                return outList.get(outList.size()-1);
            }
            else{
                StringBuilder finalSb = outList.get(outList.size()-1);
                list.removeIf(s -> finalSb.indexOf(s)>=0);
                list.forEach(s -> finalSb.append(" "+s));
                return finalSb;
            }
        }
        return sb;
    }
}
