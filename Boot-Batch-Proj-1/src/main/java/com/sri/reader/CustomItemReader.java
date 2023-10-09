package com.sri.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
public class CustomItemReader implements ItemReader<String> {
    String[] books= {"JSE","HFJ","EJ","Spring","Spring boot","BBJ"};
	int count=0;
	
	
    public CustomItemReader() {
	    super();
	   System.out.println("CustomItemReader.CustomItemReader()");	}


    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
	System.out.println("Start Reader");
	if(count<books.length)
	    return books[count++];
	else 
	    return null;
	
    }

}
