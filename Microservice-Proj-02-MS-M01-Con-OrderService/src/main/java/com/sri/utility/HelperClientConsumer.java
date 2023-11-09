package com.sri.utility;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HelperClientConsumer {

	@Autowired
	private DiscoveryClient client;
	@Autowired
	private RestTemplate template;

	public String discoveryClient() {

		// find and getservice instance provider app by submitting service id
		List<ServiceInstance> service_instances = client.getInstances("payment-service");

		ServiceInstance instance = service_instances.get(0);
		// get producer ms URL
		String url = instance.getUri() + "/payment" + "/pay";

		// crete RestTemplate Object
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
		return response.getBody();
	}
}
