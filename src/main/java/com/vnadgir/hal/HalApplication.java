package com.vnadgir.hal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import com.vnadgir.hal.api.resources.TestSessionResource;
import com.vnadgir.hal.api.resources.TestSessionsClientResource;
import com.vnadgir.hal.api.resources.TestSessionsService;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Environment;

import javax.ws.rs.client.Client;
import java.text.SimpleDateFormat;

public class HalApplication extends io.dropwizard.Application<HalConfiguration> {

    @Override
    public void run(HalConfiguration halConfiguration, Environment environment) throws Exception {
        ObjectMapper objectMapper = environment.getObjectMapper();
        objectMapper.registerModule(new JodaModule());
        objectMapper.setDateFormat(new ISO8601DateFormat());

        final Client client = new JerseyClientBuilder(environment)
                .build(getName());

        TestSessionsService testSessionsService = new TestSessionsService();
        RepresentationFactory representationFactory = new StandardRepresentationFactory();

        environment.jersey().register(new TestSessionsClientResource(client));
        environment.jersey().register(new TestSessionResource(testSessionsService, representationFactory));
    }

    @Override
    public String getName(){
        return "hal-dw";
    }

    public static void main(String[] args) throws Exception {
        new HalApplication().run(args);
    }
}

