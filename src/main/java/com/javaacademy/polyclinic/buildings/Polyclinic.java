package com.javaacademy.polyclinic.buildings;

import com.javaacademy.polyclinic.doctor.Doctor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Polyclinic implements PolyclinicI {
    private Cashier cashier;
    private Doctor dentist;
    private Doctor therapist;
    private Doctor juniorSurgeon;
    private Doctor seniorSurgeon;

    public Polyclinic(Cashier cashier,
                      @Qualifier("dentist") Doctor dentist,
                      @Qualifier("therapist") Doctor therapist,
                      @Qualifier("surgeonVasya") Doctor juniorSurgeon,
                      @Qualifier("surgeonMisha") Doctor seniorSurgeon) {
        this.cashier = cashier;
        this.dentist = dentist;
        this.therapist = therapist;
        this.juniorSurgeon = juniorSurgeon;
        this.seniorSurgeon = seniorSurgeon;
    }

    public void healByDentist() {
        cashier.takePay(dentist.heal());
    }

    public void healByTherapist() {
        cashier.takePay(therapist.heal());
    }

    public void healByJuniorSurgeon() {
        cashier.takePay(juniorSurgeon.heal());
    }

    public void healBySeniorSurgeon() {
        cashier.takePay(seniorSurgeon.heal());
    }
}
