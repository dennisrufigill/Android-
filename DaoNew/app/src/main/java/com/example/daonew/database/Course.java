package com.example.daonew.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;


@Entity
public
class Course {


    @Id(autoincrement = true)
    private long id;
    private String name;
    private double credit_hour;
    private double max_marks;
    @Generated(hash = 377757877)
    public Course(long id, String name, double credit_hour, double max_marks) {
        this.id = id;
        this.name = name;
        this.credit_hour = credit_hour;
        this.max_marks = max_marks;
    }
    @Generated(hash = 1355838961)
    public Course() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getCredit_hour() {
        return this.credit_hour;
    }
    public void setCredit_hour(double credit_hour) {
        this.credit_hour = credit_hour;
    }
    public double getMax_marks() {
        return this.max_marks;
    }
    public void setMax_marks(double max_marks) {
        this.max_marks = max_marks;
    }

}

