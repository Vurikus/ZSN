package web.model;

import javax.persistence.*;

//@Entity
//@Table(name="person")
public class Person {
    //Field
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id_person")
    private int idPerson;
//    @Column(name="name")
    private String name;
//    @Column(name="surname")
    private String surname;
//    @Column(name="patronymic")
    private String patronymic;
//    @Column(name="age")
    private int age;
    //@OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    //@JoinColumn(name = "person_id")
    //private Passport passport;

    //private Address address;

    //Constructor
    public Person() {
    }

    public Person(String name, String surname, String patronymic, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

    public Person(int idPerson, String name, String surname, String patronymic, int age) {
        this.idPerson = idPerson;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

//    public Person(String name, String surname, String patronymic, int age, Passport passport, Address address) {
//        this.name = name;
//        this.surname = surname;
//        this.patronymic = patronymic;
//        this.age = age;
//        this.passport = passport;
//        this.address = address;
//    }

    //Function

    //Getter and Setter
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public web.model.Passport getPassport() {
//        return passport;
//    }
//
//    public void setPassport(web.model.Passport passport) {
//        this.passport = passport;
//    }
//
//    public web.model.Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(web.model.Address address) {
//        this.address = address;
//    }
}
