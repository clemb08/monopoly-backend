package com.kenavo.monopoly.models;

import javax.persistence.*;

@Entity
@Table(name="player")
public class Player {

    @Id
    @GeneratedValue
    private int Id;
    @Column(name = "name")
    private String Name;
    @Column(name = "game")
    private int Game;
    @Column(name = "image")
    private String Image;
    @Column(name = "account")
    private int Account;

    public Player() {
    }

    public Player(String name, int game, String image, int account) {
        Name = name;
        Game = game;
        Image = image;
        Account = account;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getGame() {
        return Game;
    }

    public void setGame(int game) {
        Game = game;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getAccount() {
        return Account;
    }

    public void setAccount(int account) {
        Account = account;
    }
}
