package com.ecoSpring.crudecommerce.model;

import java.util.Date;

public class Order {
    private Integer id;
    private String number;
    private Date creation;
    private Date reception;
    private double total;


    public Order() {
    }


    public Order(Integer id, String number, Date creation, Date reception, double total) {
        this.id = id;
        this.number = number;
        this.creation = creation;
        this.reception = reception;
        this.total = total;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getReception() {
        return this.reception;
    }

    public void setReception(Date reception) {
        this.reception = reception;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }  
}
