package com.vnadgir.hal.api.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.vnadgir.hal.api.model.CEFRLevel;
import com.vnadgir.hal.api.model.Gender;
import com.vnadgir.hal.api.model.Modality;
import com.vnadgir.hal.api.model.PersonalDetails;
import com.vnadgir.hal.api.model.TestScores;
import com.vnadgir.hal.api.model.TestSession;
import com.vnadgir.hal.api.model.pagination.PaginatedResourceList;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TestSessionsService {

    public PaginatedResourceList<TestSession> getTestSessions(TestSessionSearchBoundsParams params){
        String id = UUID.randomUUID().toString();
        PersonalDetails personalDetails = getPersonalDetails(id);
        TestScores detailedScore = getDetailedScore(id);

        List<TestSession> testSessions = Lists.newArrayList(new TestSession(id, personalDetails, "CLDS201509HBC", detailedScore));
        PaginatedResourceList<TestSession> paginatedResourceList = PaginatedResourceList.builder()
                .withNextLink(URI.create("/test-sessions?from=01-01-2014&to01-08-2014&offset=41&limit=40"))
                .withSelfLink(URI.create("/test-sessions?from=01-01-2014&to01-08-2014&offset=1&limit=40"))
                .withResources(testSessions)
                .build();

        return paginatedResourceList;
    }

    private TestScores getDetailedScore(String testSessionId) {
        HashMap<Modality, Integer> detailedScore = Maps.newHashMap();
        detailedScore.put(Modality.LISTENING, 129);
        detailedScore.put(Modality.READING, 870);
        detailedScore.put(Modality.GRAMMAR, 789);
        return new TestScores(100, CEFRLevel.C1, detailedScore);
    }

    private PersonalDetails getPersonalDetails(String testSessionId){
        return new PersonalDetails("Vaishakh", "Nadgir", DateTime.now(), "vaishakh.nadgir@ef.com", "1234567890", Gender.MALE, "London", "United Kingdom", DateTime.now().minusYears(38));
    }

}
