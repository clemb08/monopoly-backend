package com.kenavo.monopoly.controllers;

import com.kenavo.monopoly.models.Player;
import com.kenavo.monopoly.repositories.IPlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class PlayerController {

    @Autowired
    private IPlayerRepo playerRepo;

    @CrossOrigin(origins = "http://localhost:3000")
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

    @CrossOrigin(origins = "http://localhost:3000")
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/id")
    public @ResponseBody Player getById(@RequestParam int id) {
        Optional<Player> optionalPlayer = playerRepo.findById(id);
        if (optionalPlayer.isPresent()) {
            return optionalPlayer.get();
        }
        return null;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/game/id")
    public @ResponseBody List<Player> getByGameId(@RequestParam int id) {
        Iterable<Player> iterablePlayer = playerRepo.findAll();
        List<Player> playersOfGame = StreamSupport.stream(iterablePlayer.spliterator(), false)
                .filter(player -> player.getGame() == id)
                .collect(Collectors.toList());
        return playersOfGame;
    }
}
