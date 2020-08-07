package web.model;

import java.time.LocalDate;

public class Passport {
    //Field
    private int series;
    private int number;
    private String issuingDepartment;
    private LocalDate dateIssue;

    //Constructor
    public Passport() {
    }

    public Passport(int series, int number, String issuingDepartment, LocalDate dateIssue) {
        this.series = series;
        this.number = number;
        this.issuingDepartment = issuingDepartment;
        this.dateIssue = dateIssue;
    }

    //Function

    //Getter and Setter

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIssuingDepartment() {
        return issuingDepartment;
    }

    public void setIssuingDepartment(String issuingDepartment) {
        this.issuingDepartment = issuingDepartment;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }
}
