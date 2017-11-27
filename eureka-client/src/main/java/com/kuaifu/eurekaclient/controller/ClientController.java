package com.kuaifu.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(path="helloService", method=RequestMethod.GET)
	public String helloService() {
		ServiceInstance instance = client.getLocalServiceInstance();
		System.out.println("Host: " + instance.getHost() + " serviceId: " + instance.getServiceId());
		return "Hello world";
	}
}
