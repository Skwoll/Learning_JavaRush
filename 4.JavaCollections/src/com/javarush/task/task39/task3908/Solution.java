package com.javarush.task.task39.task3908;

import java.util.HashMap;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        String tmp = s.toUpperCase();
        int even = tmp.length() % 2;

        HashMap<Character, Integer> map = new HashMap<>();
        boolean result = true;

        for (char c :
                tmp.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else {
                map.put(c,1);
            }
        }

        // у палиндрома четной длины не может быть нечетноего количества символов
        if (even == 0) {
            for (int i :
                    map.values()) {
                if (i%2 != 0 ){
                    result = false;
                    break;
                }
            }
        }
        else{//у палнидрома нечетной блины должен быть только один символ нечетного кличества (центра полиндрома)
            int cnt = 0;
            for (int i :
                    map.values()) {
                if (i % 2 == 1) {
                    cnt++;
                }
            }
            result = cnt == 1 ? true : false;
        }

        return result;
    }
}
