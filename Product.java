package net.vsevolod.shop.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "supplier_id")
    private long supplierID;

    @Column(name = "supplier_name")
    private String supplierName;


    @Column(name = "line_item")
    @OneToMany(mappedBy="line_item_id", orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<LineItem> lineItem; // 1



}
