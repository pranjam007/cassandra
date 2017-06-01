package com.arqiva.cassandra_demo.configuration;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;



/**
 * Created by pranjal.mathur on 18/08/2016.
 */
@Configuration
@PropertySource(value = {"classpath:cassandra.properties"})
public class DemoConfiguration  {

    @Autowired
    private Environment environment;

    @Bean
    public Cluster cluster() {
        Cluster cluster = Cluster.builder().addContactPoint(environment.getProperty("cassandra.contactpoints")).build();
        return cluster;
    }

    @Bean
    public Session session() throws Exception {
        Session session = cluster().connect(environment.getProperty("cassandra.keyspace"));
        return session;
    }
}
