package com.example.clinic.services;

import com.example.clinic.entities.Appointment;
import com.example.clinic.repositories.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public Appointment updateAppointment(Long id, Appointment appointment) {
        // Ищем существующую запись по ID
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);

        if (existingAppointment.isPresent()) {
            Appointment existing = existingAppointment.get();

            // Обновляем поля записи
            existing.setDoctor(appointment.getDoctor());
            existing.setPatient(appointment.getPatient());
            existing.setService(appointment.getService());
            existing.setAppointmentDate(appointment.getAppointmentDate());

            // Сохраняем обновлённую запись
            return appointmentRepository.save(existing);
        }

        // Если запись не найдена, возвращаем null
        return null;
    }


}