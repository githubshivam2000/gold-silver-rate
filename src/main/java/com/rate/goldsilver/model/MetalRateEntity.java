package com.rate.goldsilver.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "metal_rates")
public class MetalRateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double gold;
    private double silver;

    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public double getGold() {
        return gold;
    }

    public void setGold(double gold) {
        this.gold = gold;
    }

    public double getSilver() {
        return silver;
    }

    public void setSilver(double silver) {
        this.silver = silver;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
