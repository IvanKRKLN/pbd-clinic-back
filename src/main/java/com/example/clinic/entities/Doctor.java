package com.example.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "doctors")
@Data // Lombok генерирует геттеры, сеттеры, toString, equals и hashCode
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}
