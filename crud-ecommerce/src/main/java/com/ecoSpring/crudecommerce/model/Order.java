package com.ecoSpring.crudecommerce.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ordenes")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private Date creation;
    private Date reception;
    private double total;

    /*relacion con usuario JPA*/
    @ManyToOne
    private Usuario usuario;

    @OneToOne(mappedBy = "order")
    private OrderDetail orderDetail;


    /*constructor */
    public Order() {
    }


    public Order(Integer id, String number, Date creation, Date reception, double total) {
        this.id = id;
        this.number = number;
        this.creation = creation;
        this.reception = reception;
        this.total = total;
    }


    /*getters - setters */
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


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public OrderDetail getOrderDetail() {
        return this.orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    /*toString() */
    @Override
    public String toString() {
		return "Order [id=" + id + ", number=" + number + ", creation=" + creation + ", reception=" + reception
				+ ", total=" + total + "]";
	}

}
