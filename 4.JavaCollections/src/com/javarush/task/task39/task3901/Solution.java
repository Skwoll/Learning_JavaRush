package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
Реализуй метод lengthOfLongestUniqueSubstring таким образом, чтобы он возвращал длину самой длинной подстроки без повторяющихся символов, найденной в строке полученной в качестве параметра.
Например, для строки "a123bcbcqwe" - 6, а для строки "ttttwt" - 2.
Если анализируемая строка пуста или равна null - верни 0.


Требования:
1. Метод lengthOfLongestUniqueSubstring должен возвращать длину подстроки с максимальным количеством уникальных символов.
2. Метод lengthOfLongestUniqueSubstring должен возвращать 0 для пустой строки, или строки равной null.
3. Метод lengthOfLongestUniqueSubstring должен быть публичным.
4. Метод lengthOfLongestUniqueSubstring должен быть статическим.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {

        if (s == null || s.isEmpty())
          return 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i);
            Set<Character> set = new HashSet<>();
            for (char c :
                    tmp.toCharArray()) {
                if (!set.contains(c))
                    set.add(c);
                else {
                    max = max < set.size() ? set.size() : max;
                    set.clear();
                    set.add(c);
                }
            }
            if (set.size() > max)
                max = set.size();
        }

        return max;
    }
}
