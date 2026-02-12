package com.rate.goldsilver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rate.goldsilver.repository.MetalRateRepository;

@RestController
public class MetalRateController {

    private final MetalRateRepository repository;

    public MetalRateController(MetalRateRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rates")
    public Object getAllRates() {
        return repository.findAll();
    }
}
