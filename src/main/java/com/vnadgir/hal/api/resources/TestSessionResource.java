package com.vnadgir.hal.api.resources;

import com.google.common.base.Optional;
import com.theoryinpractise.halbuilder.api.Representation;
import com.vnadgir.hal.api.HalMediaType;
import com.vnadgir.hal.api.model.TestSession;
import com.vnadgir.hal.api.representations.TestSessionRepresentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static javax.ws.rs.core.Response.ok;

@Path("/test-sessions")
public class TestSessionResource {


    @GET
    public Response getTestSessions(@QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("userId") String userId, @Context HttpHeaders httpHeaders){
        MediaType acceptedMediaType = getAcceptedMediaType(httpHeaders);
        TestSession session = new TestSession(UUID.randomUUID().toString());
        Representation representation = new TestSessionRepresentation().get(session);
        return ok(representation.toString(acceptedMediaType.toString())).build();
    }

    private MediaType getAcceptedMediaType(HttpHeaders httpHeaders) {
        Optional<MediaType> accepted = Optional.absent();
        for (MediaType mediaType : httpHeaders.getAcceptableMediaTypes()) {
            if (mediaType.isCompatible(HalMediaType.APPLICATION_HAL_JSON_TYPE)) {
                accepted = Optional.of(HalMediaType.APPLICATION_HAL_JSON_TYPE);
                break;
            }
            if (mediaType.isCompatible(HalMediaType.APPLICATION_HAL_XML_TYPE)) {
                accepted = Optional.of(HalMediaType.APPLICATION_HAL_XML_TYPE);
                break;
            }
        }
        if (!accepted.isPresent()) {
            throw new WebApplicationException(Response.Status.NOT_ACCEPTABLE);
        }
        return accepted.get();
    }
}
