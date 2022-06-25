package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;


@Entity
@Table(name = "Spid")


public class Spid extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    @OneToOne
    @JoinColumn(name ="userId")

    private User user;
    private Status status;
    private Type type;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUserId() {
        return id;
    }

    public User getId(){
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Spid (Date createdAt , String createdBy , User user , long id , Status status , Type type){
        super(createdAt , createdBy);
        this.id = id;
        this.status = status;
        this.user = user;
        this.status = status;
    }

    public Spid(){

    }

}
