package com.example.clinic.dto;


public class IncomeStats {
    private String period; // месяц или год
    private double totalIncome;

    public IncomeStats(String period, double totalIncome) {
        this.period = period;
        this.totalIncome = totalIncome;
    }

    // Getters and Setters
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }
}
