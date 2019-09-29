package com.example.daonew.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Users {



    @Id(autoincrement = true)
    private Long Id;
    private int status;
    private String name;
    private String gender;

    @Override
    public String toString() {
       // return Id + "\n" + name + "\n" + gender + "\n" + status;

        return "Id:"+Id + "\n" + "Name:"+name+ "\n" +"Gender: "+gender +  "\n" + "Status: " +status;
    }

    // @Generated(hash = 1896176420)
//    public Users(long id, int status, String name, String gender) {
//        this.Id = id;
//        this.status = status;
//        this.name = name;
//        this.gender = gender;
//    }
    @Generated(hash = 2146996206)
    public Users() {
    }
    @Generated(hash = 550963759)
    public Users(Long Id, int status, String name, String gender) {
        this.Id = Id;
        this.status = status;
        this.name = name;
        this.gender = gender;
    }
    public Long getId() {
        return this.Id;
    }

    public int getStatus() {
        return this.status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setId(Long id) {
        this.Id = id;
    }


}
