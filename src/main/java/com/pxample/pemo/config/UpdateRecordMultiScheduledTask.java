package com.pxample.pemo.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
@EnableAsync
public class UpdateRecordMultiScheduledTask {

    @Async
    @Scheduled(cron = "0/10 * * * * ?")
    public void theFirstTask() {
        System.err.println("Multi task +++++ " + LocalDateTime.now());
    }
}