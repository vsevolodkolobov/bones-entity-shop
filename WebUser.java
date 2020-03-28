package net.vsevolod.shop.entity;


import net.vsevolod.shop.entity.enums.UserState;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "web_user")
public class WebUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "web_user_id")
    private long id;

    @Column(name = "password")
    private String password;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private UserState state;

    @Column(name = "shopping_cart")
    @OneToMany(mappedBy="shopping_cart_id", orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<ShoppingCart> shoppingCart; // 1

    @Column(name = "customer")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="customer_id")
    private Customer customer; // 0...1




}
