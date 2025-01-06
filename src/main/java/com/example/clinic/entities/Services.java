package com.example.clinic.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity
@Table(name = "services")
@Data
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("name")  // Настроим имя поля в JSON как "serviceName"
    private String name;

    @Column(nullable = false)
    @JsonProperty("price")  // Настроим имя поля в JSON как "servicePrice"
    private Double price;

    @Override
    public String toString() {
        return name + " (" + price + "₽)";
    }
}
