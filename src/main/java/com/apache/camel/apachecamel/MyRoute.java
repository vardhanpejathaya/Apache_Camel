package com.apache.camel.apachecamel;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		//Move data from one file to other file
		
		System.out.println("Started");
		//moveFile();
		moveFilebyName("myfile");
		System.out.println("End");
		
	}
	
	public void moveFile() {
		from("file:C://Vardhan//Personal//Workspace//vara?noop=true").to("file:C://Vardhan//Personal//Workspace//varb");
	}
	
	public void moveFilebyName(String name) {
		from("file:C://Vardhan//Personal//Workspace//vara?noop=true")
		.filter(header(Exchange.FILE_NAME).startsWith(name))
		.to("file:C://Vardhan//Personal//Workspace//varb");
	}

}
