package com.Airbnb.app.model;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * Created by romanroma on 26.09.15.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue (generator = "increment")
    @GenericGenerator (name = "increment", strategy = "increment")
    @Column (name = "id")
    private Integer id;

    @Column (name = "login")
    private String login;

    @Column (name = "password")
    private String password;

    @Column (name = "email")
    private String email;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "isHost")
    private Boolean isHost;

    public User(){}

    public User(String login, String password, String email, String name, String surname, Boolean isHost) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.isHost = isHost;
    }

    public User(String login, String password, String email) {
        this (login, password, email, "", "", false);
    }

    public User(String login, String password, String email, Boolean isHost) {
        this (login, password, email, "", "", isHost);
    }


    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Boolean getIsHost() {
        return isHost;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setIsHost(Boolean isHost) {
        this.isHost = isHost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;

        if (!(obj instanceof User)) return false;

        User other = (User) obj;

        return id.equals(other.id) &&
                login.equals(other.login) &&
                password.equals(other.password) &&
                email.equals(other.email) &&
                isHost == other.isHost &&
                name.equals(other.name) &&
                surname.equals(other.surname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isHost=" + isHost +
                '}';
    }
}
