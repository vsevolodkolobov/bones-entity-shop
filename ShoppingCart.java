package net.vsevolod.shop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collection;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shopping_cart_id")
    private long id;

    @Column(name = "created")
    private SimpleDateFormat created;

    @Column(name = "account")
    @OneToOne(optional=false, mappedBy="account_id")
    private Account account; // 1

    @Column(name = "web_user")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="web_user_id")
    private WebUser webUser; // 0...1

    @Column(name = "line_item")
    @OneToMany(mappedBy="line_item_id", orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<LineItem> lineItem; // 1




}
