package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by z001qgd on 12/21/17.
 */
public class BasicRouter extends RouteBuilder {
    public void configure() throws Exception {


        from("file:data/input/?noop=true")
                .process(new MyProcessor())
                .to("log:DSADAS?LogginLevel=INFO&")
                .to("file:data/output?fileName=deneme.json")
                .to("mock:output")
                 .to("file:data/otheroutput");
    }
}
