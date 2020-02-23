package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

        Map<String,String> map= new LinkedHashMap<>();
        map.put("name" ,"Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        params.forEach((s, s2) -> {
            if (s2 != null){
                sb.append(String.format(" and %s = '%s'", s, s2));
            }
        });

        if (sb.length()>0 )
            sb.replace(0, 5, "");

        return sb.toString();
    }
}
