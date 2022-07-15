package com.ecoSpring.crudecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double qty;
    private double price;
    private double total;


    /*relaciona con detalle de orden JPA */
    @OneToOne
    private Order order;

    /*relaciona con producto JPA*/
    @ManyToOne
    private Product producto;

    /*constructor */
    public OrderDetail() {
    }


    public OrderDetail(Integer id, String name, double qty, double price, double total) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.total = total;
     
    }


    /*getters -setters */
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

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProducto() {
        return this.producto;
    }

    public void setProducto(Product producto) {
        this.producto = producto;
    }

    /*toString() */
    @Override
    public String toString() {
		return "OrderDetail [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price
				+ ", total=" + total + "]";
	}

}
