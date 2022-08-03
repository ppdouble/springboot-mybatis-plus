package com.pxample.pemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class UpdateRecordScheduledTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void theFirstTask() {
        System.err.println("Scheduled task: ----- " + LocalDateTime.now());
    }
}