package com.sri.job_listner;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringApplication implements JobExecutionListener {

    private long startime,endtime;
    @Override
    public void beforeJob(JobExecution jobExecution) {
        // TODO Auto-generated method stub
	System.err.println(" job Execution start");
        startime=System.currentTimeMillis();
    }
    
    @Override
    public void afterJob(JobExecution jobExecution) {
	System.out.println("Job Task Completed");
      endtime=System.currentTimeMillis();
      System.out.println("Total time for Job Execution is  :"+(endtime-startime));
    }
}
