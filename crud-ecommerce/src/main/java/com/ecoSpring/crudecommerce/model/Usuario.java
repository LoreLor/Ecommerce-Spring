package com.ecoSpring.crudecommerce.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String rol;

    /*relacion con productos */
    @OneToMany(mappedBy = "usuario")
    private List<Product> productos;

    @OneToMany(mappedBy = "usuario")
    private List<Order> ordenes;


    public Usuario() {
    }


    public Usuario(Integer id, String name, String username, String email, String password, String address, String phone, String rol) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.rol = rol;
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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public List<Product> getProductos() {
        return this.productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", rol=" + rol + ", password=" + password
				+ "]";
	}

}