package model;

import java.time.LocalDate;

public class Unemployed extends Person {
    //Field
    private LocalDate regDateZSN;
    private float amountBenefit;

    //Constructor
    public Unemployed() {
    }

    public Unemployed(String name, String surname, String patronymic, int age, Passport passport, Address address, LocalDate regDateZSN, float amountBenefit) {
        super(name, surname, patronymic, age, passport, address);
        this.regDateZSN = regDateZSN;
        this.amountBenefit = amountBenefit;
    }


    //Function

    //Getter and Setter
    public LocalDate getRegDateZSN() {
        return regDateZSN;
    }

    public void setRegDateZSN(LocalDate regDateZSN) {
        this.regDateZSN = regDateZSN;
    }

    public float getAmountBenefit() {
        return amountBenefit;
    }

    public void setAmountBenefit(float amountBenefit) {
        this.amountBenefit = amountBenefit;
    }
}
