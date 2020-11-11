package com.kenavo.monopoly.repositories;

import com.kenavo.monopoly.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface IPlayerRepo extends CrudRepository<Player, Integer> {
}
