package com.bloomtech.crudyrestaurants.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The entity allowing interaction with the payments table.
 */
@Entity
@Table(name = "payments")
public class Payment
{
    /**
     * The primary key number (long) of the payments table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentid;

    /**
     * The type (String) of payment. Cannot be null and must be unique.
     */
    @Column(nullable = false,
        unique = true)
    private String type;

    /**
     * Creates a join table joining Restaurants and Payments in a Many-To-Many relations.
     * Contains a Set of Restaurant Objects using this Payment method.
     */
    @ManyToMany(mappedBy = "payments")
    @JsonIgnoreProperties(value = "payments")
    private Set<Restaurant> restaurants = new HashSet<>();

    /**
     * Default Constructor used primarily by the JPA.
     */
    public Payment()
    {
    }

    /**
     * Given the type, create a new payment object. Restaurant gets added later.
     * <p>
     * paymentid is autogenerated.
     *
     * @param type The type (String) of payment. Cannot be null.
     */
    public Payment(String type)
    {
        this.type = type;
    }

    /**
     * Getter for paymentid.
     *
     * @return The primary key number (long) of the payments table.
     */
    public long getPaymentid()
    {
        return paymentid;
    }

    /**
     * Setter for paymentid - used primarily when seeding data.
     *
     * @param paymentid The new primary key (long) number of the payments table.
     */
    public void setPaymentid(long paymentid)
    {
        this.paymentid = paymentid;
    }

    /**
     * Getter for type.
     *
     * @return The type (String) of the payment.
     */
    public String getType()
    {
        return type;
    }

    /**
     * Setter for type.
     *
     * @param type The new type (String) of this payment.
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Getter for the Restaurants using this payment.
     *
     * @return Set of Restaurant objects using this payment.
     */
    public Set<Restaurant> getRestaurants()
    {
        return restaurants;
    }

    /**
     * Setter for the Restaurants using this payment.
     *
     * @param restaurants The new set of Restaurant objects using this payment.
     */
    public void setRestaurants(Set<Restaurant> restaurants)
    {
        this.restaurants = restaurants;
    }
}
