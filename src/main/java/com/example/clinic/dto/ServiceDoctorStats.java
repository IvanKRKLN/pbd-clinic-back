package com.example.clinic.dto;

public class ServiceDoctorStats {
    private String doctorName;
    private String serviceName;
    private long serviceCount;

    public ServiceDoctorStats(String doctorName, String serviceName, long serviceCount) {
        this.doctorName = doctorName;
        this.serviceName = serviceName;
        this.serviceCount = serviceCount;
    }

    // Getters and Setters
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(long serviceCount) {
        this.serviceCount = serviceCount;
    }
}
