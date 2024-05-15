package main.java.org.example.entity;

public class Poluchatel {
    int id;
    String family;
    String name;
    String otchestvo;
    String street;
    int house;
    int flat;

    public Poluchatel(int id, String family, String name, String otchestvo, String street, int house, int flat) {
        this.id = id;
        this.family = family;
        this.name = name;
        this.otchestvo = otchestvo;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public int getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }
}
