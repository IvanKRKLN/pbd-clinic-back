package com.example.clinic.services;

import com.example.clinic.entities.Doctor;
import com.example.clinic.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServices {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            doctor.setFullName(doctorDetails.getFullName());
            doctor.setDepartment(doctorDetails.getDepartment());
            // обновите другие поля, если они есть
            return doctorRepository.save(doctor);
        } else {
            return null; // или выбросить исключение, если нужно
        }
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
}
