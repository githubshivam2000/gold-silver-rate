package com.rate.goldsilver.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.rate.goldsilver.model.MetalRateEntity;
import com.rate.goldsilver.repository.MetalRateRepository;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class MetalRateScheduler {

    private final MetalRateRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public MetalRateScheduler(MetalRateRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void fetchAndStoreRate() {

        Map goldResponse = restTemplate.getForObject(
                "https://api.gold-api.com/price/XAU", Map.class);

        Map silverResponse = restTemplate.getForObject(
                "https://api.gold-api.com/price/XAG", Map.class);

        double goldPrice = Double.parseDouble(goldResponse.get("price").toString());
        double silverPrice = Double.parseDouble(silverResponse.get("price").toString());

        MetalRateEntity rate = new MetalRateEntity();
        rate.setGold(goldPrice);
        rate.setSilver(silverPrice);
        rate.setCreatedAt(LocalDateTime.now());

        repository.save(rate);

        System.out.println("Saved Live Gold & Silver Price");
    }
}
