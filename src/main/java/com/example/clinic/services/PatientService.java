package com.example.clinic.services;

import com.example.clinic.entities.Doctor;
import com.example.clinic.entities.Patients;
import com.example.clinic.repositories.DoctorRepository;
import com.example.clinic.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patients> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patients getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patients createPatient(Patients patient) {
        return patientRepository.save(patient);
    }

    public Patients updatePatient(Long id, Patients patientDetails) {
        Optional<Patients> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patients patients= optionalPatient.get();
            patients.setFullName(patientDetails.getFullName());
            patients.setDob(patientDetails.getDob());

            // обновите другие поля, если они есть
            return patientRepository.save(patients);
        } else {
            return null; // или выбросить исключение, если нужно
        }
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
