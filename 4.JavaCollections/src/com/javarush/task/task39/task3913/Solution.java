package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
        LogParser logParser = new LogParser(Paths.get("/Users/pavelrybinskij/Documents/Обучение/Java/JavaRush/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
        System.out.println(logParser.getUniqueIPs(null, null));
        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko",null, null));
        System.out.println(logParser.getIPsForEvent(Event.SOLVE_TASK,null, null));
        System.out.println(logParser.getIPsForStatus(Status.OK, null, null));
    }
}