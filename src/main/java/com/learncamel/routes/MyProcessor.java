package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyProcessor  implements Processor {

	public void process(Exchange exchange) throws Exception {

		String body = exchange.getIn().getBody(String.class);

		String replace = body.replace(",", ":");

		exchange.getIn().setBody(replace);
	}

	
}
