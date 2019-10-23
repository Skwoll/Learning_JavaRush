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
        System.out.println("====================================");
        System.out.println(logParser.getAllUsers());
        System.out.println(logParser.getNumberOfUsers(null,null));
        System.out.println(logParser.getNumberOfUserEvents("Eduard Petrovich Morozko",null,new Date()));
        System.out.println(logParser.getUsersForIP("127.0.0.1",null,null));
        System.out.println(logParser.getLoggedUsers(null,null));
        System.out.println(logParser.getDownloadedPluginUsers(null,null));
        System.out.println(logParser.getWroteMessageUsers(null,null));
        System.out.println(logParser.getSolvedTaskUsers(null,null));
        System.out.println(logParser.getSolvedTaskUsers(null,null,18));
        System.out.println(logParser.getDoneTaskUsers(null,null));
        System.out.println(logParser.getDoneTaskUsers(null,null,48));
        System.out.println("====================================");
        System.out.println(logParser.getDatesForUserAndEvent("Amigo1",Event.SOLVE_TASK, null,null));
        System.out.println(logParser.getDatesWhenSomethingFailed(null,null));
        System.out.println(logParser.getDatesWhenErrorHappened(null,null));
        System.out.println(logParser.getDateWhenUserLoggedFirstTime("Amigo",null,null));
        System.out.println(logParser.getDateWhenUserSolvedTask("Amigo",18,null,null));
        System.out.println(logParser.getDateWhenUserDoneTask("Amigo",18,null,null));
        System.out.println(logParser.getDatesWhenUserWroteMessage("Amigo",null,null));
        System.out.println(logParser.getDatesWhenUserDownloadedPlugin("Eduard Petrovich Morozko",null,null));
        System.out.println("====================================");
        System.out.println(logParser.getAllSolvedTasksAndTheirNumber(null,null));
        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null,null));
        System.out.println("====================================");
        System.out.println(logParser.execute("get ip"));
        System.out.println(logParser.execute("get user"));
        System.out.println(logParser.execute("get date"));
        System.out.println(logParser.execute("get event"));
        System.out.println(logParser.execute("get status"));
        System.out.println("====================================");
        System.out.println(logParser.execute("get ip for user = \"amigo\""));
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));
        System.out.println("====================================");
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get date for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get event for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get status for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get user for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\""));
        System.out.println("====================================");
        System.out.println(logParser.execute("get ip for user = \"Amigo\" and date between \"01.01.2012 0:00:00\" and \"01.01.2015 0:00:00\""));

    }
}