package com.example.kuafor.service;

import com.example.kuafor.entity.Barber;
import com.example.kuafor.repository.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarberService {
    @Autowired
    private BarberRepository barberRepository;

    public String saveBarber(Barber barber){
        return barberRepository.save(barber).toString();
    }

    public String updateBarber(int id, Barber updatedBarber) {
        Optional<Barber> optionalBarber = barberRepository.findById(id);

        if (optionalBarber.isPresent()) {
            Barber existingBarber = optionalBarber.get();

            // Güncellenmek istenen özellikleri ayarla
            existingBarber.setName(updatedBarber.getName());
            existingBarber.setWorkingHours(updatedBarber.getWorkingHours());

            // Veritabanına kaydet
            barberRepository.save(existingBarber);

            return "Barber updated successfully";
        } else {
            return "Barber not found with id: " + id;
        }
    }

    public List<Barber> getBarbers(){
        return barberRepository.findAll();
    }

    public Barber getBarberById(int id){
        return barberRepository.findById(id).orElse(null);
    }

    public String delete(int id) {
        barberRepository.deleteById(id);

        return "Barber successful removed";
    }
}
