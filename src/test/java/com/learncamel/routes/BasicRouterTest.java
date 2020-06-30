package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001qgd on 12/22/17.
 */
public class BasicRouterTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){

        return new BasicRouter();

    }

    @Test
    public void predicateTest() throws InterruptedException {

    	MockEndpoint endpoint=getMockEndpoint("mock:output");
    	
    	endpoint.expectedBodiesReceived("samet:eray:erdem");
    	endpoint.assertIsSatisfied();
    }




}
