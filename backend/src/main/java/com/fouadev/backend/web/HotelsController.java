package com.fouadev.backend.web;

import com.fouadev.backend.entities.CryptoCurrency;
import com.fouadev.backend.repositories.CryptoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class HotelsController {
    private CryptoRepository hotelRepository;

    public HotelsController(CryptoRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    @GetMapping("/crypto")
    public List<CryptoCurrency> listHotels(){
        return hotelRepository.findAll();
    }
}
