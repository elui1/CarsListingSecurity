package com.example.demo;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String manufacturer;
    private String model;
    private String year;
    private double MSRP;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
    private Category category;

    public Car() {
    }

    public Car(String manufacturer, String model, String year, double MSRP, Category category) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.MSRP = MSRP;
        this.category = category;
    }

    public Car(String manufacturer, String model, String year, double MSRP) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.MSRP = MSRP;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getMSRP() {
        return MSRP;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
