package com.example.demo.Entities;

import java.util.Date;

public class Base {

    private Date createdAt;
    private String createdBy;


    public Base (Date createdAt , String createdBy){
        this.createdAt = createdAt ;
        this.createdBy = createdBy ;

    }
    public Base () {

    }

}
