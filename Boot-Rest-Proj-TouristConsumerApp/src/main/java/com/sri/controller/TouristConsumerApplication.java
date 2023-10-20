package com.sri.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sri.model.Tourist;

@Controller
public class TouristConsumerApplication {

    @Autowired
    private RestTemplate template;

    @Autowired
    private ObjectMapper mapper;

    @GetMapping
    public String getMapping() {
	return "home";
    }

    @GetMapping("/touristData")
    public String GetAllTouristData(Map<String, Object> model) throws Exception {
	/*
	 * EndPoints:
	 * uri:
	 * body:none
	 * header:none
	 * pathvariable/requestparam:none
	 */
	String URI="http://localhost:4040/allTourist";
	ResponseEntity<String> message = template.exchange(URI, HttpMethod.GET, null, String.class);
	String msg = message.getBody();

	try {
	    Set<Tourist> listOfObj = mapper.readValue(msg, new TypeReference<Set<Tourist>>() {
	    });
	    model.put("objList", listOfObj);
	    return "touristdetails";
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	    throw e;
	}
    }
}
