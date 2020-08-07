package web.model;

import java.time.LocalDate;

public class Unemployed extends web.model.Person {
    //Field
    private LocalDate regDateZSN;
    private float amountBenefit;

    //Constructor
    public Unemployed() {
    }

//    public Unemployed(String name, String surname, String patronymic, int age, web.model.Passport passport, web.model.Address address, LocalDate regDateZSN, float amountBenefit) {
//        super(name, surname, patronymic, age, passport, address);
//        this.regDateZSN = regDateZSN;
//        this.amountBenefit = amountBenefit;
//    }


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
