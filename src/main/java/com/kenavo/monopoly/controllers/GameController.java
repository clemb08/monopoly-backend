package com.kenavo.monopoly.controllers;

import com.kenavo.monopoly.models.Game;
import com.kenavo.monopoly.repositories.IGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping(path="api/game")
public class GameController {

    @Autowired
    private IGameRepo gameRepo;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path="/add")
    public @ResponseBody String createGame (@RequestParam String name){
        System.out.println(name);
        Game game = new Game(new Date(System.currentTimeMillis()), name);
        gameRepo.save(game);
        return "Saved";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Game> getAllGames() {
        return gameRepo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path="/id")
    public @ResponseBody Optional<Game> getById(@RequestParam int id){
        return gameRepo.findById(id);
    }
}
