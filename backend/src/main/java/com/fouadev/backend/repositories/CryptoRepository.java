package com.fouadev.backend.repositories;

import com.fouadev.backend.entities.CryptoCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptoRepository extends JpaRepository<CryptoCurrency, String> {
}
