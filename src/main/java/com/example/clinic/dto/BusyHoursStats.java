package com.example.clinic.dto;

public class BusyHoursStats {
    private int hour;
    private long appointmentsCount;

    public BusyHoursStats(int hour, long appointmentsCount) {
        this.hour = hour;
        this.appointmentsCount = appointmentsCount;
    }

    // Getters and Setters
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public long getAppointmentsCount() {
        return appointmentsCount;
    }

    public void setAppointmentsCount(long appointmentsCount) {
        this.appointmentsCount = appointmentsCount;
    }
}
