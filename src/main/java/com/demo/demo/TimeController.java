package com.demo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {

    @GetMapping("/time")

    // This annotation allows you to retrieve parameters from the request URL. In this
    // case, it retrieves the timeZone parameter. The required = false parameter
    // indicates that the parameter is optional, and defaultValue = "UTC" provides
    // a default value if the parameter is not provided.

    public String getCurrentTime(@RequestParam(required = false, defaultValue = "UTC") String timeZone) {
        LocalDateTime currentTime = LocalDateTime.now();

        ZoneId zoneId = ZoneId.of(timeZone);
        LocalDateTime convertedTime = currentTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(zoneId).toLocalDateTime();

        // Format the time as per your requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = convertedTime.format(formatter);

        // Return the formatted time
        return "Current Time in " + timeZone + " Timezone: " + formattedTime;

        //test in browser:
        // http://localhost:8081/time  - fara parametru
        // http://localhost:8081/time?timeZone=CET - cu parametru



    }
}
