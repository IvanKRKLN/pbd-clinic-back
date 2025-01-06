package com.example.clinic.repositories;

import com.example.clinic.entities.Patients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patients, Long> {
}
