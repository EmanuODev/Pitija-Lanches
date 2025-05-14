package com.ecommerc.backend.entites;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class Carts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "products_variations_id")
    private ProductsVariations item;
    private int quantity;
    private float subtotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public ProductsVariations getItem() {
        return item;
    }

    public void setItem(ProductsVariations item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
