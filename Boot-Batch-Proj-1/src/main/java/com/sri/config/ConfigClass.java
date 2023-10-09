package com.sri.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.sri.job_listner.JobMonitoringApplication;

@Configuration
@EnableBatchProcessing
public class ConfigClass {
    @Autowired
    private StepBuilderFactory step;;
    @Autowired
    private JobBuilderFactory job;
    @Autowired
    private ItemWriter<String> bookWriter;
    @Autowired
    private ItemReader<String> bookReader;
    @Autowired
    private ItemProcessor<String,String> bookProcessor;
    @Autowired
    private PlatformTransactionManager manager;
    @Autowired
    private JobMonitoringApplication listner;
    
    @Autowired
    private JobRepository repository;
    @Bean("MyJob1")
    public Job jobCreated(JobRepository repository) {
	System.err.println("job");
	return job.get("MyJob1")
		.incrementer(new RunIdIncrementer())
		.listener(listner)
		.start(stepBuilder(repository,manager))
		.build();
		
    }
    @Bean("MyStep1")
    public Step stepBuilder(JobRepository repository,PlatformTransactionManager manager) {
	System.err.println("Step");
	return step.get("MyStep1")
		.<String,String>chunk(2)
		.reader(bookReader)
		.processor(bookProcessor)
		.writer(bookWriter)
		.build();
    }
}
