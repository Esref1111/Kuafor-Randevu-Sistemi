package com.example.kuafor.controller;

import com.example.kuafor.entity.Barber;
import com.example.kuafor.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barbers")
public class BarberController {

    @Autowired
    private BarberService barberService;

    @PostMapping
    public ResponseEntity<String> saveBarber(@RequestBody Barber barber) {
        String result = barberService.saveBarber(barber);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBarber(@PathVariable int id, @RequestBody Barber updatedBarber) {
        String result = barberService.updateBarber(id, updatedBarber);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<List<Barber>> getBarbers() {
        List<Barber> barbers = barberService.getBarbers();
        return ResponseEntity.ok(barbers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barber> getBarberById(@PathVariable int id) {
        Barber barber = barberService.getBarberById(id);
        return ResponseEntity.ok(barber);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBarber(@PathVariable int id) {
        String result = barberService.delete(id);
        return ResponseEntity.ok(result);
    }
}
