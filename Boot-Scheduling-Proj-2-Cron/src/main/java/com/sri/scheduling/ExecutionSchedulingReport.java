package com.sri.scheduling;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExecutionSchedulingReport {

    @Scheduled(cron = "4 13 20 1 * *")
    public void getScheduling() {
	System.out.println(Thread.currentThread().hashCode());
	System.out.println("Task start  :" + new Date());
    }
}
