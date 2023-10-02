package com.sri.scheduling;

import java.util.Date;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "prod")
public class ExecutionSchedulingReport {

    //@Scheduled(cron = "4 13 20 1 * *")
    //@Scheduled(cron = "0 10-20 19 2 10 *")
    //@Scheduled(cron="0-59 0-59 19 2 10 mon")
    @Scheduled(cron= "0 0-59 19 2 oct tue")
    public void getScheduling() {
	System.out.println("Report 1 :"+new Date());
	System.out.println("Task start  :" + new Date());
    }
    
    
}
