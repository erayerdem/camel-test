package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DirectTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() {

        return new RedirectExample();

    }

    @Test
    public void testDirect() {

        String output = (String) template.requestBody("direct:input", "ahm");

        assertEquals(output, "ahma");
    }

    @Test
    public void testDirectWithMock() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived("ahm");
        template.sendBody("direct:input", "ahmet");

        assertMockEndpointsSatisfied();
    }
}
