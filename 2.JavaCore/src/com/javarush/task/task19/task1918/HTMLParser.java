package com.javarush.task.task19.task1918;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser {



    public static List<String> ParseHTMLTag (String tag,String file){
        Stack<Integer> integerStack = new Stack<>();
        List<String> result = new ArrayList<>();

        Matcher m = Pattern.compile("<(/?)" + tag + ".*?>").matcher(file);
        TreeMap<Integer,Integer> map = new TreeMap();

        while (m.find()){
            if (file.charAt(m.start()+1)== '/'){
                map.put(integerStack.pop(),m.end());

            }else {
                integerStack.push(m.start());
            }
        }

        map.forEach((integer, integer2) -> result.add(file.substring(integer,integer2)));


        return result;
    }

}
