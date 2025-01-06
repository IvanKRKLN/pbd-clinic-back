package com.example.clinic.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "departments")
@Data // Lombok генерирует геттеры, сеттеры, toString, equals и hashCode
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
