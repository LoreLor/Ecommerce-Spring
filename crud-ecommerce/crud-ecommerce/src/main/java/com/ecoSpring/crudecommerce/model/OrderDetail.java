package com.ecoSpring.crudecommerce.model;

public class OrderDetail {
    private Integer id;
    private String name;
    private double qty;
    private double price;
    private double total;


    public OrderDetail() {
    }


    public OrderDetail(Integer id, String name, double qty, double price, double total) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
