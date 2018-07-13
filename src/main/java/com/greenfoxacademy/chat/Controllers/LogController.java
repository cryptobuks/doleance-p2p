package com.greenfoxacademy.chat.Controllers;

import com.greenfoxacademy.chat.Models.Log;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LogController {
    String writeLog(String logLevel, String path, String method, String... requestData) {
        List<String> requestDataList = new ArrayList<>();
        for ( String data : requestData) {
            requestDataList.add(data);
        }
        Log newLog = new Log(logLevel, path, method, requestDataList);
        return newLog.getLog();
    }
}
