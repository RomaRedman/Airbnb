package com.Airbnb.app.testSpring;

import javax.persistence.*;
import javax.persistence.Entity;
import static javax.persistence.DiscriminatorType.*;

import org.hibernate.annotations.*;


/**
 * Created by romanroma on 01.12.15.
 */
@Entity
@Cacheable
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Column (name = "name")
    private String name;

    public Customer (){

    }

    public Customer(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
