package com.sri.runner;

import java.util.Random;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class BatchRunner implements CommandLineRunner {

    @Autowired
    private JobLauncher luncher;
    
    @Autowired
    private Job job;
    @Override
    public void run(String... args) throws Exception {
	//Create Job Parameter
	JobParameters builder=new JobParametersBuilder().addLong("Id", new Random().nextLong(1000l, 2000l)).toJobParameters();
	System.err.println("Runner start");
	JobExecution execution= luncher.run(job,builder);
	System.out.println(execution.getStatus());
	System.out.println(execution.getExitStatus());
	System.out.println(execution.getId());
    }
}