package com.learncamel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public class OtherRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:otherroute")
                .log("logger ${body[0][username]}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        List<LinkedCaseInsensitiveMap> body = exchange.getIn().getBody(List.class);
                        body.forEach(e -> {
                            System.out.println(e.get("userid"));
                            System.out.println(e.get("username"));
                        });
                    }
                })
                .log("sss");
    }
}
