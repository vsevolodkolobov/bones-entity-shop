package net.vsevolod.shop.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "line_item")
public class LineItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_item_id")
    private long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price; // real price

    @Column(name = "order")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="order_id")
    private Order order; // 1

    @Column(name = "shopping_cart")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="shopping_cart_id")
    private ShoppingCart shoppingCart; // *

    @Column(name = "product")
    @ManyToOne(optional=false, cascade= CascadeType.ALL)
    @JoinColumn(name="product_id")
    private Product product;



}
