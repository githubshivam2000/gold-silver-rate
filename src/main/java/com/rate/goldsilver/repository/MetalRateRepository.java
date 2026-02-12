package com.rate.goldsilver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rate.goldsilver.model.MetalRateEntity;

public interface MetalRateRepository
        extends JpaRepository<MetalRateEntity, Long> {
}
