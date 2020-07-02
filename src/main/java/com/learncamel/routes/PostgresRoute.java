package com.learncamel.routes;

import com.learncamel.routes.InsertProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

/**
 * Created by Dilip on 5/26/17.
 */
public class PostgresRoute extends RouteBuilder {

    public void configure() throws Exception {

        onException(PSQLException.class).handled(true).log("Exception While inserting messages.");

        from("file:data/input/?noop=true")
                .process(new InsertProcessor())
                //.to("jdbc:db")
                .to("sql:select * from users where userid=:#${property.id}?dataSource=db&outputType=SelectList&outputClass=com.learncamel.routes.DbModel")
                .to("direct:otherroute");


    }


}