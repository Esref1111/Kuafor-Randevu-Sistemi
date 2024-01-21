package com.example.kuafor.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Barber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String workingHours;

    // Getter ve Setter metotları

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }
}
