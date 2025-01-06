package com.example.clinic.controllers;

import com.example.clinic.entities.Appointment;
import com.example.clinic.entities.Department;
import com.example.clinic.entities.Doctor;
import com.example.clinic.repositories.DoctorRepository;
import com.example.clinic.services.AppointmentService;
import com.example.clinic.services.DepartmentService;
import com.example.clinic.services.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorServices doctorService;
    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/getAll")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }


    @GetMapping("/getDoctorById/{doctorId}")
    public Doctor getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return doctorService.getDoctorById(doctorId);
    }

    @PostMapping("/createDoctor")
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        // Выводим содержимое объекта doctor для проверки
        System.out.println("Received doctor object: " + doctor);

        if (doctor == null) {
            throw new IllegalArgumentException("JSON пустой или некорректный");
        }
        if (doctor.getFullName() == null || doctor.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("ФИО не может быть пустым");
        }
        if (doctor.getDepartment() == null || doctor.getDepartment().getId() == null) {
            throw new IllegalArgumentException("Отделение или его ID не могут быть пустыми");
        }

        Department department = departmentService.getDepartmentById(doctor.getDepartment().getId());
        if (department == null) {
            throw new IllegalArgumentException("Отделение с указанным ID не найдено");
        }

        doctor.setDepartment(department);
        return doctorService.createDoctor(doctor);
    }


    @PutMapping("updateDoctor/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        return doctorService.updateDoctor(id, doctorDetails);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }

}