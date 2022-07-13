package com.ecoSpring.crudecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="productos")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String image;
    private double price;
    private int qty;


    /* Atributo para relacionar el producto con el usuario */
    @ManyToOne
    private Usuario usuario;



    public Product() {
    }


    public Product(Integer id, String name, String description, String image, double price, int qty, Usuario usuario) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.qty = qty;
        this.usuario = usuario;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return this.qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image
				+ ", price=" + price + ", qty=" + qty +  "]";
	}

}
