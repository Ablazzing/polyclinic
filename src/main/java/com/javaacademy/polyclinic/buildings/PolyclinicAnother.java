package com.javaacademy.polyclinic.buildings;

import com.javaacademy.polyclinic.config.DoctorProperties;
import com.javaacademy.polyclinic.doctor.Doctor;
import com.javaacademy.polyclinic.doctor.DoctorSpecialization;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static com.javaacademy.polyclinic.doctor.DoctorSpecialization.DENTIST;
import static com.javaacademy.polyclinic.doctor.DoctorSpecialization.SURGEON;
import static com.javaacademy.polyclinic.doctor.DoctorSpecialization.THERAPIST;

@Component
@AllArgsConstructor
public class PolyclinicAnother implements PolyclinicI {
    private Cashier cashier;
    private List<Doctor> doctors;
    private DoctorProperties doctorProperties;

    public void healByDentist() {
        healBySpecializationAndPrice(DENTIST, doctorProperties.getDentist());
    }

    public void healByTherapist() {
        healBySpecializationAndPrice(THERAPIST, doctorProperties.getTherapist());
    }

    public void healByJuniorSurgeon() {
        healBySpecializationAndPrice(SURGEON, doctorProperties.getJuniorSurgeon());
    }

    public void healBySeniorSurgeon() {
        healBySpecializationAndPrice(SURGEON, doctorProperties.getSeniorSurgeon());
    }

    private void healBySpecializationAndPrice(DoctorSpecialization specialization,
                                              BigDecimal price) {
        Doctor doctor = findDoctorBySpecializationAndPrice(specialization, price);
        cashier.takePay(doctor.heal());
    }

    private Doctor findDoctorBySpecializationAndPrice(DoctorSpecialization specialization,
                                                      BigDecimal price) {
        return doctors.stream()
                .filter(doctor -> Objects.equals(doctor.getPrice(), price)
                                  && Objects.equals(specialization, doctor.getSpecialization()))
                .findFirst()
                .orElseThrow();
    }
}
