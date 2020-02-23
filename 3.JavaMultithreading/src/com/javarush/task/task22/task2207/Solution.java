package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

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
        List<String> raw = new ArrayList<>(Arrays.asList(sb.toString().split("[ ]")));

        while (raw.size()>0) {
            String s = raw.get(0);
            String sr = new StringBuilder(s).reverse().toString();
            raw.remove(0);
            if (s.length() > 0 && raw.contains(sr)) {
                raw.remove(sr);
                Pair p = new Pair(s,sr);
                result.add(p);
            }
        }
        result.forEach(System.out::println);

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
