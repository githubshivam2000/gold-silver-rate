package com.rate.goldsilver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GoldSilverRateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoldSilverRateApplication.class, args);
    }
}
