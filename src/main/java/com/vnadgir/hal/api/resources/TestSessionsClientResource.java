package com.vnadgir.hal.api.resources;

import com.theoryinpractise.halbuilder.api.ReadableRepresentation;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import com.vnadgir.hal.api.HalMediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import java.io.StringReader;

import static javax.ws.rs.core.Response.ok;

@Path("/client")
public class TestSessionsClientResource {

    private final Client client;

    public TestSessionsClientResource(Client client) {
        this.client = client;
    }

    @GET
    public Response get(){
        String string = client.target("http://localhost:18080")
                .path("/test-sessions")
                .request(HalMediaType.APPLICATION_HAL_JSON)
                .get(String.class);

        ReadableRepresentation representation = new StandardRepresentationFactory().readRepresentation(HalMediaType.APPLICATION_HAL_JSON, new StringReader(string));
        String ordersLinkUrl = representation.getLinkByRel("next").getHref();
        return ok(ordersLinkUrl).build();
    }


}
