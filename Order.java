package net.vsevolod.shop.entity;

import net.vsevolod.shop.entity.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;

@Entity
@Table(name = "order_table")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "ordered")
    private SimpleDateFormat ordered;

    @Column(name = "shipped")
    private SimpleDateFormat shipped;

    @Column(name = "ship_to")
    private String shipTo;

    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "real")
    private int real;  // TODO:

    @Column(name = "account")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="account_id")
    private Account account; // *

    @Column(name = "line_item")
    @OneToMany(mappedBy="line_item_id", orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<LineItem> lineItem; // 1

    @Column(name = "payment")
    @OneToMany(mappedBy="payment_id", orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<Payment> payment; // 1


}
