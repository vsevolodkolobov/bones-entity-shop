package net.vsevolod.shop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private long id;

    @Column(name = "paid")
    private SimpleDateFormat paid;

    @Column(name = "total")
    private int total; // TODO:

    @Column(name = "details")
    private String details;

    @Column(name = "order")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order; // 1

    @Column(name = "account")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="account_id")
    private Account account; // *




}
