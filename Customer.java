package net.vsevolod.shop.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private long id;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private int phone;

    @Column(name = "email")
    private String email;

    @Column(name = "account")
    @OneToOne(optional = false, mappedBy = "customer")
    private Account account; // 1

    @Column(name = "web_user")
    @OneToMany(mappedBy="web_user_id", orphanRemoval = true, fetch= FetchType.EAGER)
    private Collection<WebUser> webUser; // 1




}
