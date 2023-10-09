package com.sri.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomizerDataProcesor implements ItemProcessor<String, String> {

    
    
    public CustomizerDataProcesor() {
	super();
	System.out.println("PRocessor:0::Param Constructor");
    }

    @Override
    public String process(String item) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("Strat Processor");
	String bookDetails="";
	if(item.equalsIgnoreCase("JSE"))
	    bookDetails+=item+" by Srikanta Kumar Sabata";
	else if(item.equalsIgnoreCase("BBJ"))
	    bookDetails+=item+" Natraj";
	else if(item.equalsIgnoreCase("HFJ"))
	    bookDetails+=item+" BY HK";
	else if(item.equalsIgnoreCase("EJ"))
	    bookDetails+=item+" Kanhu Sabata";
	return bookDetails;
    }
}
