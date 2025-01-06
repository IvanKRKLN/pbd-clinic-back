package com.example.clinic.repositories;

import com.example.clinic.entities.Appointment;
import com.example.clinic.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByAppointmentDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT a.service, COUNT(a) FROM Appointment a GROUP BY a.service")
    Map<Services, Long> countByService();  // Это гарантирует возвращаемое значение Map<Services, Long>

}
