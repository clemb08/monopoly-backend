package com.kenavo.monopoly.repositories;

import com.kenavo.monopoly.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface IGameRepo extends CrudRepository<Game, Integer> {
}
