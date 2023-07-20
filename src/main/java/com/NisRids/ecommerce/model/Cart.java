package com.NisRids.ecommerce.model;

import jakarta.persistence.*;


import java.util.Date;

@Entity
@Table(name="Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;
    private int quantity;
    public Cart(){

    }

    public Cart(Product product, int quantity, User user) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.createDate = new Date();
    }
}
