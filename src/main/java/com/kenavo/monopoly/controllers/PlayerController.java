package com.kenavo.monopoly.controllers;

import com.kenavo.monopoly.models.Player;
import com.kenavo.monopoly.repositories.IPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class PlayerController {

    @Autowired
    private IPlayerRepo playerRepo;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping(path="api/add")
    public @ResponseBody
    String createPlayer (@RequestParam String name,
                         @RequestParam int game,
                         @RequestParam(required = false) String file){
        int amount = 10000000;
        Player player = new Player(name, game, file, amount);
        playerRepo.save(player);
        return "Saved";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping(path="/modify")
    public @ResponseBody String modifyPlayer(@RequestParam int id,
                                             @RequestParam(required = false) String name,
                                             @RequestParam(required = false) String image,
                                             @RequestParam(required = false) Integer amount) {
        Player player = getById(id);
        if(name != null && player.getName() != name) {
            player.setName(name);
        }

        if(image != null && player.getImage() != image) {
            player.setImage(image);
        }

        if(amount != null && player.getAccount() != amount) {
            player.setAccount(amount);
        }

        playerRepo.save(player);
        return "Modified";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllGames() {
        return playerRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(path="/id")
    public @ResponseBody Player getById(@RequestParam int id) {
        Optional<Player> optionalPlayer = playerRepo.findById(id);
        if (optionalPlayer != null) {
            return optionalPlayer.get();
        }
        return null;
    }
}
