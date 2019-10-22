package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery {
    File[] files ;
    List<Log> logs = new ArrayList<>();

    public LogParser(Path logDir) {

        files = logDir.toFile().listFiles((dir, name) -> name.toLowerCase().endsWith(".log"));
        if (files == null) {
            return;
        }
        for (File file : files) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                while (br.ready()){
                    logs.add(new Log(br.readLine()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        long startDate = after == null ? 0 : after.getTime();
        long endDate = before == null ? Long.MAX_VALUE : before.getTime();

        logs.forEach(log -> {long curDate = log.LogDate.getTime();
            if (curDate>= startDate && curDate <=endDate)
                ips.add(log.IP);
        });

        return ips.size();
    }


    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        long startDate = after == null ? 0 : after.getTime();
        long endDate = before == null ? Long.MAX_VALUE : before.getTime();

        logs.forEach(log -> {long curDate = log.LogDate.getTime();
            if (curDate>= startDate && curDate <=endDate)
                ips.add(log.IP);
        });

        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        long startDate = after == null ? 0 : after.getTime();
        long endDate = before == null ? Long.MAX_VALUE : before.getTime();

        logs.forEach(log -> {long curDate = log.LogDate.getTime();
            if (curDate>= startDate && curDate <=endDate && log.User.equalsIgnoreCase(user))
                ips.add(log.IP);
        });

        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        long startDate = after == null ? 0 : after.getTime();
        long endDate = before == null ? Long.MAX_VALUE : before.getTime();

        logs.forEach(log -> {long curDate = log.LogDate.getTime();
            if (curDate>= startDate && curDate <=endDate && log.LogEvent.equals(event))
                ips.add(log.IP);
        });

        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ips = new HashSet<>();
        long startDate = after == null ? 0 : after.getTime();
        long endDate = before == null ? Long.MAX_VALUE : before.getTime();

        logs.forEach(log -> {long curDate = log.LogDate.getTime();
            if (curDate>= startDate && curDate <=endDate && log.LogStatus.equals(status))
                ips.add(log.IP);
        });

        return ips;
    }

    @Override
    public Set<String> getAllUsers() {
        return logs.stream().map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return logs.stream().filter(log ->  log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime())).map(Log::getUser).collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return logs.stream().filter(log -> log.getUser().equalsIgnoreCase(user)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return logs.stream().filter(log -> log.getIP().equalsIgnoreCase(ip)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.LOGIN)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DOWNLOAD_PLUGIN)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.WRITE_MESSAGE)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DONE_TASK)
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DONE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDate()>= (after==null?0:after.getTime())
                && log.getLogDate()<= (before==null?Long.MAX_VALUE:before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }
}