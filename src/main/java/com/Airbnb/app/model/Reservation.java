package com.Airbnb.app.model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by romanroma on 19.11.15.
 */
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "apartmentId")
    private Apartment apartment;

    @Column(name = "dateFrom")
    private Date dateFrom;

    @Column(name = "dateTo")
    private Date dateTo;

    @Column(name = "comment")
    private String comment;

    public Reservation() {}

    public Reservation(User user, Apartment apartment, Date dateFrom, Date dateTo, String comment) {
        this.user = user;
        this.apartment = apartment;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        if (!(obj instanceof Reservation)) return false;

        Reservation other = (Reservation) obj;

        return id.equals(other.id) &&
                user.equals(other.user) &&
                apartment.equals(other.apartment) &&
                dateFrom.equals(other.dateFrom) &&
                dateTo.equals(other.dateTo) &&
                comment.equals(other.comment);
    }
}
