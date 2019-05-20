package com.edmointel.bonneyfx.model;

import java.time.LocalDate;
import java.time.Period;

public class Recipient extends Person {
    private boolean isDeceased;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public Recipient(String name, boolean isDeceased, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        super(name);
        this.isDeceased = isDeceased;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String NL = System.getProperty("line.separator");

        result.append(this.getClass().getName() + " Object {" + NL);
        result.append(super.toString());
        result.append("isDeceased: " + isDeceased + NL);
        result.append("Date of Birth: " + dateOfBirth + NL);
        result.append("Date of Death: " + dateOfDeath + NL);
        result.append("}");


        return result.toString();

    }

    public boolean diedOverOneYearAgo() {
        return Period.between(dateOfDeath, LocalDate.now()).getYears() > 1;
    }

    public boolean isDeceased() {
        return isDeceased;
    }

    public int getAge() {
        if (isDeceased) {
            return Period.between(dateOfBirth, dateOfDeath).getYears();
        } else
            return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }



}
