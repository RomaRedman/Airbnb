package com.Airbnb.app.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Created by romanroma on 28.09.15.
 */
@Entity
@Table(name = "apartment")
public class Apartment {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "hostId")
    private User host;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    @Column(name = "type")
    private ApartType apartmentType;

    public Apartment() {
    }

    public Apartment(User host, City city, ApartType apartmentType) {
        this.host = host;
        this.city = city;
        this.apartmentType = apartmentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ApartType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartType apartmentType) {
        this.apartmentType = apartmentType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Apartment)) return false;

        Apartment other = (Apartment) obj;

        return id.equals(other.id) &&
                host.equals(other.host) &&
                city.equals(other.city) &&
                apartmentType.equals(other.apartmentType);
    }
}