package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class RedirectExample extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:input")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String body = exchange.getIn().getBody(String.class);
                        String ahmet = body.substring(0, 3);
                        exchange.getIn().setBody(ahmet);
                    }
                }).to("mock:output");
    }
}
