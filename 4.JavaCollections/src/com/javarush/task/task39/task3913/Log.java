package com.javarush.task.task39.task3913;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
*ip - ip адрес с которого пользователь произвел событие.
*user - имя пользователя (одно или несколько слов разделенные пробелами).
*date - дата события в формате day.month.year hour:minute:second.
*event - одно из событий:
*  LOGIN - пользователь залогинился,
*  DOWNLOAD_PLUGIN - пользователь скачал плагин,
*  WRITE_MESSAGE - пользователь отправил сообщение,
*  SOLVE_TASK - пользователь попытался решить задачу,
*  DONE_TASK - пользователь решил задачу.
*  Для событий SOLVE_TASK и DONE_TASK существует дополнительный параметр,
*  который указывается через пробел, это номер задачи.
*status - статус:
*  OK - событие выполнилось успешно,
*  FAILED - событие не выполнилось,
*  ERROR - произошла ошибка.
**/
public class Log {
    public String IP;
    public String User;
    public Date LogDate;
    public Event LogEvent;
    public Status LogStatus;
    public String TaskNumber;

    public Log(String IP, String user, Date logDate, Event logEvent, Status logStatus, String taskNumber) {
        this.IP = IP;
        User = user;
        LogDate = logDate;
        LogEvent = logEvent;
        LogStatus = logStatus;
        TaskNumber = taskNumber == null ? "" : taskNumber;
    }
    public Log (String str){
        try {
            String[] values = str.split("\\t");
            if (values[3].startsWith("SOLVE_TASK") || values[3].startsWith("DONE_TASK")) {
                IP = values[0];
                User =        values[1];
                LogDate =        new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(values[2]);
                LogEvent = Event.valueOf(values[3].split(" ")[0]);
                LogStatus = Status.valueOf(values[4]);
                TaskNumber = values[3].split(" ")[1];
            } else {
                IP= values[0];
                User =        values[1];
                LogDate =        new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(values[2]);
                LogEvent=        Event.valueOf(values[3]);
                LogStatus=        Status.valueOf(values[4]);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public Date getLogDate() {
        return LogDate;
    }

    public void setLogDate(Date logDate) {
        LogDate = logDate;
    }

    public Event getLogEvent() {
        return LogEvent;
    }

    public void setLogEvent(Event logEvent) {
        LogEvent = logEvent;
    }

    public Status getLogStatus() {
        return LogStatus;
    }

    public void setLogStatus(Status logStatus) {
        LogStatus = logStatus;
    }

    public String getTaskNumber() {
        return TaskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        TaskNumber = taskNumber;
    }
}
