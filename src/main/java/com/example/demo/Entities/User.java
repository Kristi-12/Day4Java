package com.example.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Table (name = "users")
public class User extends Base{

    @Id
    private long id ;
    private String name;
    private String surname;
    private String cardNo;
    private String username;
    private String password;
    private String email;


    public User (long id , Date createdAt , String createdBy , String name , String surname , String cardNo , String username ,String password ,String email){
        super(createdAt , createdBy);
        this.id = id ;
        this.name = name ;
        this.surname = surname ;
        this.cardNo = cardNo;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(){
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
