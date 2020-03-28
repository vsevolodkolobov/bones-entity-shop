package net.vsevolod.shop.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 *
 *@author Vsevolod Kolobov
 */


@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "account_id")
private long id;

@Column(name = "address")
@NotNull
private String billingAddress;

@Column(name = "is_closed")
private Boolean isClosed;

@Column(name = "open")
private SimpleDateFormat open;

@Column(name = "closed")
private SimpleDateFormat closed;

@Column(name = "customer")
@OneToOne(optional = false, cascade = CascadeType.ALL)
@JoinColumn(name = "customer_id")
private Customer customer;  // 1

@Column(name = "shopping_cart")
@OneToOne(optional = false, cascade = CascadeType.ALL)
@JoinColumn(name = "shopping_cart_id")
private ShoppingCart shoppingCart; // 1

@Column(name = "payment")
@OneToMany(mappedBy="payment_id", orphanRemoval = true, fetch= FetchType.EAGER)
private Collection<Payment> payment; // 1

@Column(name = "order")
@OneToMany(mappedBy="order_id", orphanRemoval = true, fetch= FetchType.EAGER)
private Collection<Order> order; // 1

}
