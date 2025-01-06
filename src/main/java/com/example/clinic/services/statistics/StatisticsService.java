package com.example.clinic.services.statistics;

import com.example.clinic.dto.*;
import com.example.clinic.repositories.AppointmentRepository;
import com.example.clinic.repositories.ServiceRepository;
import com.example.clinic.repositories.statistics.StatisticsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final AppointmentRepository appointmentRepository;
    private final ServiceRepository serviceRepository;
    private StatisticsRepository statisticsRepository;

    public long getTotalAppointments() {
        return appointmentRepository.count();
    }

    public List<Map.Entry<String, Long>> getPopularServices() {
        return appointmentRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        appointment -> appointment.getService().getName(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5) // Получить топ-5 популярных услуг
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Double>> getRevenueByService() {
        return appointmentRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        appointment -> appointment.getService().getName(),
                        Collectors.summingDouble(appointment -> appointment.getService().getPrice())
                ))
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toList());
    }


    public List<IncomeStats> getMonthlyIncome(int year) {
        return statisticsRepository.fetchMonthlyIncome(year);
    }

    public List<IncomeStats> getYearlyIncome() {
        return statisticsRepository.fetchYearlyIncome();
    }

    public List<NewPatientsStats> getNewPatients(int year) {
        return statisticsRepository.fetchNewPatients(year);
    }

    public List<BusyDaysStats> getBusyDays() {
        return statisticsRepository.fetchBusyDays();
    }

    public List<BusyHoursStats> getBusyHours() {
        return statisticsRepository.fetchBusyHours();
    }

    public List<ServiceDoctorStats> getServiceDoctorStats() {
        return statisticsRepository.fetchServiceDoctorStats();
    }

    public List<ServiceCombinationStats> getServiceCombinations() {
        return statisticsRepository.fetchServiceCombinations();
    }


}
