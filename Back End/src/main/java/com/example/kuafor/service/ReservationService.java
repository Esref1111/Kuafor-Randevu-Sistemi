package com.example.kuafor.service;

import com.example.kuafor.entity.Reservation;
import com.example.kuafor.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public String saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
        return "Reservation saved successfully";
    }

    public String updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if (optionalReservation.isPresent()) {
            Reservation existingReservation = optionalReservation.get();

            // Güncellenmek istenen özellikleri ayarla
            existingReservation.setBarber(updatedReservation.getBarber());
            existingReservation.setCustomerName(updatedReservation.getCustomerName());
            existingReservation.setDate(updatedReservation.getDate());
            existingReservation.setTime(updatedReservation.getTime());

            // Veritabanına kaydet
            reservationRepository.save(existingReservation);

            return "Reservation updated successfully";
        } else {
            return "Reservation not found with id: " + id;
        }
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public String deleteReservation(Long id) {
        reservationRepository.deleteById(id);

        return "Reservation successfully removed";
    }
}
