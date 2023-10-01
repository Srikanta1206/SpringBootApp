package com.sri.scheduling;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ExecutionScheduling {

    @Scheduled(initialDelay = 2000,fixedDelay = 3000)
    public void getScheduling() {
	System.out.println("ExecutionScheduling.getScheduling()"+new Date());
	try {
	    Thread.sleep(4000);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	System.out.println("Task start  :"+new Date());
    }
}
