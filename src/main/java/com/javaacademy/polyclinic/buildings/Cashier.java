package com.javaacademy.polyclinic.buildings;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

/**
 * Касса
 */
@Slf4j
@Component
public class Cashier {
    private BigDecimal income = ZERO;

    /**
     * Принятие платежа
     */
    public void takePay(BigDecimal pay) {
        income = income.add(pay);
    }

    /**
     * Печать дохода
     */
    public void printIncome() {
       log.info("Доход клиники {}", income);
    }
}
