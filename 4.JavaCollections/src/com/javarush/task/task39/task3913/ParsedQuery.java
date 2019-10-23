package com.javarush.task.task39.task3913;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParsedQuery {
    private String field1;
    private String field2;
    private String value1;
    private String after;
    private String before;
    private SimpleDateFormat dateParser = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public ParsedQuery(String query) {
        if (query.contains("\" and date between \"")) {
            Pattern p = Pattern.compile("^get\\s(.*?)\\sfor\\s(.*?)\\s=\\s\"(.*)\"\\sand date between\\s\"(.*?)\"\\sand\\s\"(.*?)\"");
            Matcher m = p.matcher(query);
            m.find();
            field1 = m.group(1);
            field2 = m.group(2);
            value1 = m.group(3);
            after = m.group(4);
            before = m.group(5);
        } else if (query.contains(" = \"")) {

            Pattern p = Pattern.compile("get\\s(.*?)\\sfor\\s(.*?)\\s=\\s\"(.*)\"");
            Matcher m = p.matcher(query);
            m.find();
            field1 = m.group(1);
            field2 = m.group(2);
            value1 = m.group(3);
        } else {
            Pattern p = Pattern.compile("^get\\s(.*?)$");
            Matcher m = p.matcher(query);
            m.find();
            field1 = m.group(1);
        }
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getValue1() {
        return value1;
    }

    public long getValue1DateLong(){

        try {
            return value1 == null ? 0 : dateParser.parse(value1).getTime();
        } catch (ParseException e) {

        }
        return 0;
    }

    public String getAfter() {
        return after;
    }

    public String getBefore() {
        return before;
    }
    public long getAfterLong() {
        try {
            return after== null ? 0 : dateParser.parse(after).getTime();
        } catch (ParseException e) {
        }
        return 0;
    }

    public long getBeforeLonf(){
        try {
            return before == null ? Long.MAX_VALUE : dateParser.parse(before).getTime();
        } catch (ParseException e) {
        }

        return 0;
    }
}
