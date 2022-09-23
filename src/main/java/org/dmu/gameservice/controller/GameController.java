package org.dmu.gameservice.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.dmu.gameservice.entity.Player;
import org.dmu.gameservice.service.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController für das Spiel.
 * Hier wird die Rest-API definiert.
 */
@RestController
@RequestMapping("players")
@CrossOrigin(origins = { "http://localhost:3000"})
@Data
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class GameController {

    final private GameService service;

    @PutMapping("/{type}")
    public Player createPlayer(@PathVariable String type) {
        return service.createPlayer(type);
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id) {
        return service.getPlayer(id);
    }

    @GetMapping("/winner/{botId}/{playerId}")
    public Player getPlayerWinner(@PathVariable int botId, @PathVariable int playerId) {
        return service.getPlayerWinner(botId, playerId);
    }

    @PatchMapping("/{id}/name/{name}")
    public Player updatePlayerName(@PathVariable int id, @PathVariable String name) {
    	return service.updatePlayerName(id, name);
    }

    @PatchMapping("/{id}/symbol/{symbol}")
    public Player updatePlayerSymbol(@PathVariable int id, @PathVariable String symbol) {
    	return service.updatePlayerSymbol(id, symbol);
    }

}
