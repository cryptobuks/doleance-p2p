package com.greenfoxacademy.chat.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Log {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date date;
    String logLevel;
    String path;
    String method;
    List<String> requestData = new ArrayList<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateAndTime() {
        Calendar cal = Calendar.getInstance ();
        this.date = cal.getTime();
        return date;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<String> getRequestData() {
        return requestData;
    }

    public void setRequestData(List<String> requestData) {
        this.requestData = requestData;
    }

    public Log(String logLevel, String path, String method, List<String> requestData) {
        getDateAndTime();
        this.logLevel = logLevel;
        this.path = path;
        this.method = method;
        this.requestData = requestData;
    }

    public String getLog() {
        StringBuilder stringBuilder = new StringBuilder(this.date.toString());
        stringBuilder.append(" " + this.logLevel);
        stringBuilder.append(" " + this.path);
        stringBuilder.append(" " + this.method);
        stringBuilder.append(" " + this.requestData);
        return stringBuilder.toString();
    }
}
