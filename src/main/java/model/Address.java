package model;

public class Address {
    //Field
    private String region;
    private String city;
    private String street;
    private String building;
    private int apartment;

    //Constructor

    public Address() {
    }

    public Address(String region, String city, String street, String building, int apartment) {
        this.region = region;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }


    //Function

    //Getter and Setter

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }
}
