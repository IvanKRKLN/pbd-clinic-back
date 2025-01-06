package com.example.clinic.services.statistics;

import com.example.clinic.repositories.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonthlyStatisticsService {
    private final AppointmentRepository appointmentRepository;

    public Map<String, Double> getDepartmentStatistics(YearMonth month) {
        LocalDate startDate = month.atDay(1);
        LocalDate endDate = month.atEndOfMonth();

        return appointmentRepository.findByAppointmentDateBetween(startDate, endDate).stream()
                .collect(Collectors.groupingBy(
                        appointment -> appointment.getDoctor().getDepartment().getName(),
                        Collectors.summingDouble(appointment -> appointment.getService().getPrice())
                ));
    }

    public Map<String, Double> getDoctorStatistics(YearMonth month) {
        LocalDate startDate = month.atDay(1);
        LocalDate endDate = month.atEndOfMonth();

        return appointmentRepository.findByAppointmentDateBetween(startDate, endDate).stream()
                .collect(Collectors.groupingBy(
                        appointment -> appointment.getDoctor().getFullName(),
                        Collectors.summingDouble(appointment -> appointment.getService().getPrice())
                ));
    }
}
