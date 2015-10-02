package com.vnadgir.hal.api.model;

import java.util.HashMap;
import java.util.Map;

public class TestScores {
    private final int testScore;
    private final CEFRLevel cefrLevel;
    private final Map<Modality, Integer> detailedScore = new HashMap<Modality, Integer>();

    public TestScores(int testScore, CEFRLevel cefrLevel, Map<Modality, Integer> detailedScore) {
        this.testScore = testScore;
        this.cefrLevel = cefrLevel;
        this.detailedScore.putAll(detailedScore);
    }

    public int getTestScore() {
        return testScore;
    }

    public CEFRLevel getCefrLevel() {
        return cefrLevel;
    }

    public Map<Modality, Integer> getDetailedScore() {
        return detailedScore;
    }
}
