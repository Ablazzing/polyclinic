package com.javaacademy.polyclinic.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;

@ConfigurationProperties(prefix = "app.doctor.price")
@Getter
@Setter
public class DoctorProperties {
    private BigDecimal juniorSurgeon;
    private BigDecimal seniorSurgeon;
    private BigDecimal dentist;
    private BigDecimal therapist;
}
