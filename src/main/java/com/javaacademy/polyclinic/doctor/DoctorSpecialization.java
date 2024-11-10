package com.javaacademy.polyclinic.doctor;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DoctorSpecialization {
    DENTIST("дантист"), SURGEON("хирург"), THERAPIST("терапевт");

    private final String description;
}
