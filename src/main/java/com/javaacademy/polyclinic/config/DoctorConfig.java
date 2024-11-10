package com.javaacademy.polyclinic.config;

import com.javaacademy.polyclinic.doctor.Doctor;
import com.javaacademy.polyclinic.doctor.DoctorSpecialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

import static com.javaacademy.polyclinic.doctor.DoctorSpecialization.DENTIST;
import static com.javaacademy.polyclinic.doctor.DoctorSpecialization.SURGEON;
import static com.javaacademy.polyclinic.doctor.DoctorSpecialization.THERAPIST;
import static java.math.BigDecimal.valueOf;

@Configuration
@EnableConfigurationProperties(DoctorProperties.class)
public class DoctorConfig {
    @Autowired
    private DoctorProperties properties;

    @Bean
    public Doctor dentist() {
        return new Doctor(properties.getDentist(), DENTIST);
    }

    @Bean
    public Doctor therapist() {
        return new Doctor(properties.getTherapist(), THERAPIST);
    }

    @Bean
    public Doctor surgeonVasya() {
        return new Doctor(properties.getJuniorSurgeon(), SURGEON);
    }

    @Bean
    public Doctor surgeonMisha() {
        return new Doctor(properties.getSeniorSurgeon(), SURGEON);
    }
}
