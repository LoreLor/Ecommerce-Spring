package com.ecoSpring.crudecommerce.model;

public class OrdenDetail {
    private Integer id;
    private String number;
    private double qty;
    private double price;
    private double total;


    public OrdenDetail() {
    }

    public OrdenDetail(Integer id, String number, double qty, double price, double total) {
        this.id = id;
        this.number = number;
        this.qty = qty;
        this.price = price;
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

    public double getQty() {
        return this.qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
