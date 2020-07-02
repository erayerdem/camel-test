package com.learncamel.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.main.Main;
import org.apache.camel.spi.Registry;
import org.apache.commons.dbcp.BasicDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class Test {
    public static void main(String[] args) throws Exception {

        Main main = new Main();
        main.bind("db", setupDataSource());
        main.addRouteBuilder(new PostgresRoute());
        main.addRouteBuilder(new OtherRoute());
        main.run();
        Thread.sleep(3000);

    }


    private static DataSource setupDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("sameteray.2");
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        return ds;
    }
}

