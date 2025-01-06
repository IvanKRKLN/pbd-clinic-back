package com.example.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data // Lombok генерирует геттеры, сеттеры, toString, equals и hashCode
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(name = "dob", nullable = false)
    private LocalDate dob; // Используем LocalDate для даты рождения

}
