package com.sri.scheduling;

import java.util.Date;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Profile(value = "dev")
public class ExecutingSchedulingReport2 {

    @Scheduled(cron= "0 0-59 19 2 oct *")
    public void reportGeneration() {
	System.out.println("Report 2");
	System.out.println("Report 2 :"+new Date());
    }
}
