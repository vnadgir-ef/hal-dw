package com.vnadgir.hal.api.resources;

import com.google.common.base.Optional;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.vnadgir.hal.api.HalMediaType;
import com.vnadgir.hal.api.model.TestSession;
import com.vnadgir.hal.api.model.pagination.PaginatedResourceList;
import io.dropwizard.jersey.params.DateTimeParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

import static javax.ws.rs.core.Response.ok;

@Path("/test-sessions")
public class TestSessionResource {

    private final TestSessionsService testSessionsService;
    private final RepresentationFactory representationFactory;

    public TestSessionResource(TestSessionsService testSessionsService, RepresentationFactory representationFactory) {
        this.testSessionsService = testSessionsService;
        this.representationFactory = representationFactory;
    }

    @GET
    @Produces("application/json")
    public Response getTestSessions(@QueryParam("fromDate") DateTimeParam from,
                                    @QueryParam("toDate") DateTimeParam to,
                                    @QueryParam("offset") int offset,
                                    @QueryParam("limit") int limit,
                                    @Context HttpHeaders httpHeaders) throws URISyntaxException {

        PaginatedResourceList<TestSession> sessions = testSessionsService.getTestSessions(new TestSessionSearchBoundsParams());

        MediaType acceptedMediaType = getAcceptedMediaType(httpHeaders);
        return getRepresentation(sessions, acceptedMediaType);
    }

    private Response getRepresentation(PaginatedResourceList<TestSession> pagination, MediaType acceptedMediaType) throws URISyntaxException {
        return ok(pagination).build();
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
