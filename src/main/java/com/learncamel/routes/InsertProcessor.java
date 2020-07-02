package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.slf4j.LoggerFactory;


public class InsertProcessor implements org.apache.camel.Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String  body = exchange.getIn().getBody(String.class).trim();
        exchange.setProperty("id",1);
        String format =String.format("insert into users values (%s,'ahmet')",body);
        exchange.getIn().setBody(format);
    }
}
