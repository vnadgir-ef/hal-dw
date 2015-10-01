package com.vnadgir.hal.api.representations;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import com.vnadgir.hal.api.model.TestSession;

public class TestSessionRepresentation {

    private static final String basePath ="/test-sessions";

    public Representation get(TestSession testSession){
        Representation testSessionsPagingRepresentation= new StandardRepresentationFactory()
                .newRepresentation(basePath)
                .withLink("next", "/test-sessions?from=0&to=10")
                .withProperty("id", testSession.getId());
        return testSessionsPagingRepresentation;


    }
}
