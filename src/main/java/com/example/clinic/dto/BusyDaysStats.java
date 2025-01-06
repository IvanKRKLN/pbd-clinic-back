package com.example.clinic.dto;

public class BusyDaysStats {
    private String dayOfWeek;
    private long appointmentsCount;

    public BusyDaysStats(String dayOfWeek, long appointmentsCount) {
        this.dayOfWeek = dayOfWeek;
        this.appointmentsCount = appointmentsCount;
    }

    // Getters and Setters
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public long getAppointmentsCount() {
        return appointmentsCount;
    }

    public void setAppointmentsCount(long appointmentsCount) {
        this.appointmentsCount = appointmentsCount;
    }
}
