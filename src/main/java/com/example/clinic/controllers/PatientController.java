package com.example.clinic.controllers;

import com.example.clinic.entities.Appointment;
import com.example.clinic.entities.Doctor;
import com.example.clinic.entities.Patients;
import com.example.clinic.repositories.DoctorRepository;
import com.example.clinic.services.AppointmentService;
import com.example.clinic.services.DoctorServices;
import com.example.clinic.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/getAll")
    public List<Patients> getAllPatients() {
        return patientService.getAllPatients();
    }


    @GetMapping("/getPatientById/{Id}")
    public Patients getAppointmentsByPatient(@PathVariable Long patientId) {
        return patientService.getPatientById(patientId);
    }

    @PostMapping("/createPatient")
    public Patients createPatient(@RequestBody Patients patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/updatePatient/{id}")
    public Patients updatePatient(@PathVariable Long id, @RequestBody Patients patientDetails) {
        return patientService.updatePatient(id, patientDetails);
    }

    @DeleteMapping("/deletePatient/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
    

}