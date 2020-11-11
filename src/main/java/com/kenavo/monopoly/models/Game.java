package com.kenavo.monopoly.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="game")
public class Game {

    @Id
    @GeneratedValue
    private String Id;
    @Column(name = "createdAt")
    private Date CreatedAt;
    @Column(name = "name")
    private String Name;

    public Game(Date createdAt, String name) {
        CreatedAt = createdAt;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
