package com.example.clinic.dto;

public class ServiceCombinationStats {
    private String service1;
    private String service2;
    private long combinationCount;

    public ServiceCombinationStats(String service1, String service2, long combinationCount) {
        this.service1 = service1;
        this.service2 = service2;
        this.combinationCount = combinationCount;
    }

    // Getters and Setters
    public String getService1() {
        return service1;
    }

    public void setService1(String service1) {
        this.service1 = service1;
    }

    public String getService2() {
        return service2;
    }

    public void setService2(String service2) {
        this.service2 = service2;
    }

    public long getCombinationCount() {
        return combinationCount;
    }

    public void setCombinationCount(long combinationCount) {
        this.combinationCount = combinationCount;
    }
}
