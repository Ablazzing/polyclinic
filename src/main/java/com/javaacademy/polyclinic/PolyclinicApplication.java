package com.javaacademy.polyclinic;

import com.javaacademy.polyclinic.buildings.Cashier;
import com.javaacademy.polyclinic.buildings.Polyclinic;
import com.javaacademy.polyclinic.buildings.PolyclinicAnother;
import com.javaacademy.polyclinic.buildings.PolyclinicI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PolyclinicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PolyclinicApplication.class, args);
		PolyclinicI polyclinic = context.getBean("polyclinicAnother", PolyclinicI.class);
		polyclinic.healByDentist();
		polyclinic.healByJuniorSurgeon();
		polyclinic.healBySeniorSurgeon();
		polyclinic.healByTherapist();

		Cashier cashier = context.getBean(Cashier.class);
		cashier.printIncome();
	}

}
