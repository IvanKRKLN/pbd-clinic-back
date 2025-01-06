package com.example.clinic.repositories.statistics;

import com.example.clinic.dto.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsRepository {

    @Query("SELECT new com.example.dto.IncomeStats(DATE_FORMAT(a.date, '%Y-%m'), SUM(a.price)) " +
            "FROM Appointment a WHERE YEAR(a.date) = :year GROUP BY DATE_FORMAT(a.date, '%Y-%m') ORDER BY DATE_FORMAT(a.date, '%Y-%m')")
    List<IncomeStats> fetchMonthlyIncome(@Param("year") int year);

    @Query("SELECT new com.example.dto.IncomeStats(YEAR(a.date), SUM(a.price)) " +
            "FROM Appointment a GROUP BY YEAR(a.date) ORDER BY YEAR(a.date)")
    List<IncomeStats> fetchYearlyIncome();

    @Query("SELECT new com.example.dto.NewPatientsStats(DATE_FORMAT(p.registrationDate, '%Y-%m'), COUNT(p)) " +
            "FROM Patient p WHERE YEAR(p.registrationDate) = :year GROUP BY DATE_FORMAT(p.registrationDate, '%Y-%m') ORDER BY DATE_FORMAT(p.registrationDate, '%Y-%m')")
    List<NewPatientsStats> fetchNewPatients(@Param("year") int year);

    @Query("SELECT new com.example.dto.BusyDaysStats(DAYNAME(a.date), COUNT(a)) " +
            "FROM Appointment a GROUP BY DAYNAME(a.date) ORDER BY COUNT(a) DESC")
    List<BusyDaysStats> fetchBusyDays();

    @Query("SELECT new com.example.dto.BusyHoursStats(HOUR(a.startTime), COUNT(a)) " +
            "FROM Appointment a GROUP BY HOUR(a.startTime) ORDER BY COUNT(a) DESC")
    List<BusyHoursStats> fetchBusyHours();

    @Query("SELECT new com.example.dto.ServiceDoctorStats(d.name, s.name, COUNT(a)) " +
            "FROM Appointment a JOIN a.doctor d JOIN a.service s " +
            "GROUP BY d.name, s.name ORDER BY COUNT(a) DESC")
    List<ServiceDoctorStats> fetchServiceDoctorStats();

    @Query("SELECT new com.example.dto.ServiceCombinationStats(s1.name, s2.name, COUNT(a1)) " +
            "FROM Appointment a1 JOIN Appointment a2 ON a1.patient.id = a2.patient.id AND a1.id < a2.id " +
            "JOIN a1.service s1 JOIN a2.service s2 " +
            "GROUP BY s1.name, s2.name ORDER BY COUNT(a1) DESC")
    List<ServiceCombinationStats> fetchServiceCombinations();
}
