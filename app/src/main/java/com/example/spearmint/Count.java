package com.example.spearmint;
/**
 * Likely do not need this class anymore
 */
public class Count {
    private String countDescription;
    private String countResult;

    Count(String countDescription, String countResult) {
        this.countDescription = countDescription;
        this.countResult = countResult;
    }

    public String getCountDescription() {
        return this.countDescription;
    }

    public String getCountResult() {
        return this.countResult;
    }
}
