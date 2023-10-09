package com.sri.writer;

import java.util.List;

import org.springframework.batch.core.step.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class CustomItemWriter implements ItemWriter<String> {

    
    public CustomItemWriter() {
	super();
	System.out.println("CustomItemWriter::0-Param Constructor");
    }
    
    @Override
    public void write(List<? extends String> items) throws Exception {
	System.out.println("CustomItemWriter start");
	items.stream().forEach(System.out::println);
	
    }

}
