package com.sri.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	// String URI="http://localhost:4040/allTourist"; //when producer app/server app
	// is running in embadded server
	String URI = "http://localhost:8083/Boot-Rest-proj-MiniPrroject/allTourist";
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

    @GetMapping("/edit")
    public String editTourist(@ModelAttribute Tourist tourist, @RequestParam Integer id)
	    throws Exception, JsonProcessingException {
	/*
	 * EndPoints
	 * uri:
	 * pathvariable:id
	 * entity:headers+body
	 */
	String URI = "http://localhost:8083/Boot-Rest-proj-MiniPrroject/specific/{tid}";
	ResponseEntity<String> json_msg = template.exchange(URI, HttpMethod.GET, null, String.class, id);
	String msg = json_msg.getBody();
	// convert json_msg to Tourist obj
	Tourist trst = mapper.readValue(msg, Tourist.class);

	BeanUtils.copyProperties(trst, tourist);
	return "edit_tourist";
    }

    @PostMapping("/edit")
    public String updateTouristRecord(RedirectAttributes attrs, @ModelAttribute Tourist tourist) throws Exception {
	//pending logic for converting obj(Tourist) to String(json)
	/*Endpoints:
	 * URI:"";
	 * RequestBody:json format
	 * Headers:application.JSON
	 * Pathvariable:No
	 * */
	String URI = "http://localhost:8083/Boot-Rest-proj-MiniPrroject/update";
	//converting Object to JSON
	String json_body=mapper.writeValueAsString(tourist);
	//Set Header property
	HttpHeaders head=new HttpHeaders();
	head.setContentType(MediaType.APPLICATION_JSON);
	//set Header and body(As json)
	HttpEntity<String> entity=new HttpEntity<String>(json_body,head);
	//sending request to producer/service provider/API development app
	ResponseEntity<String> msg_body=template.exchange(URI, HttpMethod.PUT, entity, String.class);
	String msg=msg_body.getBody();
	//add in redirect scope
	attrs.addFlashAttribute("result", msg);
	
	return "redirect:touristData";
    }

    @GetMapping("/delete")
    public String deleteTourist(RedirectAttributes attrs, @RequestParam Integer id) {
	//Invoke Service Provider Operation
	/*EndPoints:
	 * uri+path(static path+dynamic path):
	 * body+headers:no
	 * pathpariable:id
	 * */
	String URI = "http://localhost:8083/Boot-Rest-proj-MiniPrroject/cancel/{id}"; //url+path
	//call rest controller operation
	ResponseEntity<String>msg_body=template.exchange(URI, HttpMethod.DELETE, null, String.class, id);
	String msg=msg_body.getBody();
	//set in redirect scope
	attrs.addFlashAttribute("result",msg);
	//redirect
	return "redirect:touristData";
    }

    @GetMapping("/add_tourist")
    public String register_tourist(@ModelAttribute Tourist tourist) {
	return "register";
    }

    @PostMapping("/add_tourist")
    public String completeRegisatration(RedirectAttributes attri, @ModelAttribute Tourist tourist) throws Exception {
	// invoke Restcontroller ServiceProvider
	/*
	 * Endpoints:
	 * URl
	 * RequestEntity:header+body
	 * content Type:Application/json
	 * pathvaribale:No
	 */

	String URI = "http://localhost:8083/Boot-Rest-proj-MiniPrroject/enroll";
	// Converting Model Obj to json body
	String json_body = mapper.writeValueAsString(tourist);
	// Set header property other are optional
	HttpHeaders header = new HttpHeaders();
	header.setContentType(MediaType.APPLICATION_JSON);
	// Set Body and Header
	HttpEntity<String> entity = new HttpEntity<String>(json_body, header);
	ResponseEntity<String> msg = template.exchange(URI, HttpMethod.POST, entity, String.class);
	String msgBody = msg.getBody();
	// set in model class obj
	attri.addFlashAttribute("result", msgBody);

	// redirect to anther handler method
	return "redirect:touristData";
    }
}
