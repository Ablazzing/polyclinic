package com.javaacademy.polyclinic.doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Slf4j
@AllArgsConstructor
@Getter
public class Doctor {
    private BigDecimal price;
    private DoctorSpecialization specialization;

    public BigDecimal heal() {
        log.debug("{} вылечил человека", capitalize(specialization.getDescription()));
        return price;
    }
}
