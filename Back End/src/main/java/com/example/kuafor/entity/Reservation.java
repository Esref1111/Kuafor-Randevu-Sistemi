package com.example.kuafor.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    private String customerName;
    private String date;
    private String time;

    // Getter ve Setter metotları

    public void setId(Long id) {
        this.id = id;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
