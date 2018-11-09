package com.chen.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClientConfig;

@RestController
public class HelloWorldController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/hello")
	public String index() {
		List<String> services = discoveryClient.getServices();
		for (String string : services) {
			List<ServiceInstance> instances = discoveryClient.getInstances(string);
			for (ServiceInstance serviceInstance : instances) {
				System.out.println("host:"+serviceInstance.getHost());
				System.out.println("port:"+serviceInstance.getPort());
				System.out.println("Scheme:"+serviceInstance.getScheme());
				
				System.out.println("getServiceId:"+serviceInstance.getServiceId());
				System.out.println("Metadata:"+serviceInstance.getMetadata());
			}
		}
		return "success";
	}
}
