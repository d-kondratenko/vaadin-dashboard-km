package com.epic.configurations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateTimeFormat {
    public String reloadDateCreated (LocalDateTime dateTime){

        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern(pattern);
        String dateCreatedStr = dateTime.format(dateTimeFormatter);
        return dateCreatedStr;
    }
    
}
