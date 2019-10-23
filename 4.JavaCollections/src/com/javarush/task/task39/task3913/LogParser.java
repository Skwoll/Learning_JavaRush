package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
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

    //region implement IPQuery
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
    //endregion

    //region implement UserQuery
    @Override
    public Set<String> getAllUsers() {
        return logs.stream().map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime())).map(Log::getUser).collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return logs.stream().filter(log -> log.getUser().equalsIgnoreCase(user)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return logs.stream().filter(log -> log.getIP().equalsIgnoreCase(ip)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.LOGIN)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DOWNLOAD_PLUGIN)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.WRITE_MESSAGE)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DONE_TASK)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DONE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getUser).collect(Collectors.toSet());
    }
    //endregion


    //region implement DataQuery
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return logs.stream().filter(log -> log.getUser().equalsIgnoreCase(user)
                && log.getLogEvent().equals(event)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogStatus().equals(Status.FAILED)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogStatus().equals(Status.ERROR)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> result =  logs.stream().filter(log -> log.getUser().equals(user)
                && log.getLogEvent().equals(Event.LOGIN)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
        return result == null || result.size() == 0 ? null : Collections.min(result);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> result = logs.stream().filter(log -> log.getUser().equals(user)
                && log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
        return result == null || result.size() == 0 ? null : Collections.min(result);

    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> result = logs.stream().filter(log -> log.getUser().equals(user)
                && log.getLogEvent().equals(Event.DONE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
        return result == null || result.size() == 0 ? null : Collections.min(result);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return logs.stream().filter(log -> log.getUser().equals(user)
                && log.getLogEvent().equals(Event.WRITE_MESSAGE)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return logs.stream().filter(log -> log.getUser().equals(user)
                && log.getLogEvent().equals(Event.DOWNLOAD_PLUGIN)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getDate).collect(Collectors.toSet());
    }
    //endregion

    //region implement EventQuery
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return logs.stream().filter(log -> log.getIP().equalsIgnoreCase(ip)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return logs.stream().filter(log -> log.getUser().equalsIgnoreCase(user)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogStatus().equals(Status.FAILED)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogStatus().equals(Status.ERROR)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toList()).size();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DONE_TASK)
                && log.getTaskNumber() == task
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                .map(Log::getLogEvent).collect(Collectors.toList()).size();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.SOLVE_TASK)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                                .collect(Collectors.toMap(Log::getTaskNumber,i -> 1,Integer::sum));
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return logs.stream().filter(log -> log.getLogEvent().equals(Event.DONE_TASK)
                && log.getLogDateLong() >= (after == null ? 0 : after.getTime())
                && log.getLogDateLong() <= (before == null ? Long.MAX_VALUE : before.getTime()))
                                .collect(Collectors.toMap(Log::getTaskNumber,i -> 1,Integer::sum));
    }
    //endregion


    //region implement QLQuery
    @Override
    public Set<Object> execute(String query) {
        ParsedQuery parsedQuery = new ParsedQuery(query);


        Set<Log> filteredLog = logs.stream().filter(log -> parsedQuery.getField2() == null ? true :
                ((parsedQuery.getAfter() != null && parsedQuery.getBefore() != null) ? (log.getLogDateLong() < parsedQuery.getBeforeLonf()
                                                                                               && log.getLogDateLong() > parsedQuery.getAfterLong() ): true)
                        && (parsedQuery.getField2().equalsIgnoreCase("ip") ? log.getIP().equalsIgnoreCase(parsedQuery.getValue1()) : true)
                        && (parsedQuery.getField2().equalsIgnoreCase("user") ? log.getUser().equalsIgnoreCase(parsedQuery.getValue1()) : true)
                        && (parsedQuery.getField2().equalsIgnoreCase("date") ? log.getLogDateLong() == parsedQuery.getValue1DateLong() : true)
                        && (parsedQuery.getField2().equalsIgnoreCase("event") ? log.getLogEvent().equals(Event.valueOf(parsedQuery.getValue1())) : true)
                        && (parsedQuery.getField2().equalsIgnoreCase("status") ? log.getLogStatus().equals(Status.valueOf(parsedQuery.getValue1())) : true)

        ).collect(Collectors.toSet());
            switch (parsedQuery.getField1()) {
                case "ip" :
                    return filteredLog.stream().map(Log::getIP).collect(Collectors.toSet());
                case "user":
                    return filteredLog.stream().map(Log::getUser).collect(Collectors.toSet());
                case "date":
                    return filteredLog.stream().map(Log::getDate).collect(Collectors.toSet());
                case "event":
                    return filteredLog.stream().map(Log::getLogEvent).collect(Collectors.toSet());
                case "status":
                    return filteredLog.stream().map(Log::getLogStatus).collect(Collectors.toSet());

                default: return null;

            }

    }




    //endregion
}