package com.example.clinic.controllers;

import com.example.clinic.dto.*;
import com.example.clinic.services.statistics.MonthlyStatisticsService;
import com.example.clinic.services.statistics.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/statistics")

public class StatisticsController {
    private final StatisticsService statisticsService;
    private final MonthlyStatisticsService monthlyStatisticsService;

    @GetMapping("/general")
    public Map<String, Object> getGeneralStatistics() {
        return Map.of(
                "totalAppointments", statisticsService.getTotalAppointments(),
                "popularServices", statisticsService.getPopularServices(),
                "revenueByService", statisticsService.getRevenueByService()
        );
    }

    @GetMapping("/monthly")
    public Map<String, Map<String, Double>> getMonthlyStatistics(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM") YearMonth month
    ) {
        return Map.of(
                "departments", monthlyStatisticsService.getDepartmentStatistics(month),
                "doctors", monthlyStatisticsService.getDoctorStatistics(month)
        );
    }
    @GetMapping("/income/monthly")
    public List<IncomeStats> getMonthlyIncome(@RequestParam int year) {
        return statisticsService.getMonthlyIncome(year);
    }

    @GetMapping("/income/yearly")
    public List<IncomeStats> getYearlyIncome() {
        return statisticsService.getYearlyIncome();
    }

    @GetMapping("/patients/new")
    public List<NewPatientsStats> getNewPatients(@RequestParam int year) {
        return statisticsService.getNewPatients(year);
    }

    @GetMapping("/calendar/busy-days")
    public List<BusyDaysStats> getBusyDays() {
        return statisticsService.getBusyDays();
    }

    @GetMapping("/calendar/busy-hours")
    public List<BusyHoursStats> getBusyHours() {
        return statisticsService.getBusyHours();
    }

    @GetMapping("/services/doctors")
    public List<ServiceDoctorStats> getServiceDoctorStats() {
        return statisticsService.getServiceDoctorStats();
    }

    @GetMapping("/services/combinations")
    public List<ServiceCombinationStats> getServiceCombinations() {
        return statisticsService.getServiceCombinations();
    }
}
