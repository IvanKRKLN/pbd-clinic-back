package com.example.clinic.dto;

public class NewPatientsStats {
    private String period; // месяц
    private long newPatientsCount;

    public NewPatientsStats(String period, long newPatientsCount) {
        this.period = period;
        this.newPatientsCount = newPatientsCount;
    }

    // Getters and Setters
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public long getNewPatientsCount() {
        return newPatientsCount;
    }

    public void setNewPatientsCount(long newPatientsCount) {
        this.newPatientsCount = newPatientsCount;
    }
}
