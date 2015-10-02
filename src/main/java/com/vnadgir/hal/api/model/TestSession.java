package com.vnadgir.hal.api.model;

public class TestSession {

    private final String id;
    private final PersonalDetails personalDetails;
    private final String testName;
    private final TestScores detailedScore;

    public TestSession(String id, PersonalDetails personalDetails, String testName, TestScores detailedScore) {
        this.id = id;
        this.personalDetails = personalDetails;
        this.testName = testName;
        this.detailedScore = detailedScore;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public String getTestName() {
        return testName;
    }

    public TestScores getDetailedScore() {
        return detailedScore;
    }

    public String getId() {
        return id;
    }
}