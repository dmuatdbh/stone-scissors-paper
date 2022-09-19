package org.dmu.gameservice.service;

import org.dmu.gameservice.entity.Player;
import org.dmu.gameservice.entity.PlayerType;
import org.dmu.gameservice.entity.Symbol;
import org.dmu.gameservice.entity.SymbolValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;

/**
 * Service Implementierung des Spiels.
 * Hält die List von {@link Player Spielern}.
 */
@Service
public class GameService {

    private final Random random = new Random();
    private final Collection<Player> players;

    public GameService() {
        players = new ArrayList<>();
    }

    public Player getPlayer(int id) {
        return getPlayerById(id);
    }

    private Player getPlayerById(int id) {
        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public Player createPlayer(String type) {
        PlayerType playerType = PlayerType.valueOf(type.toUpperCase());
        Player player = new Player(playerType);
        player.setName(Objects.equals(PlayerType.BOT, playerType)? "The Bot" : "");
        player.setId(random.nextInt(Integer.MAX_VALUE - 1));
        players.add(player);
        return player;
    }

    public Player updatePlayerName(int id, String name) {
        Player player = getPlayerById(id);
        player.setName(name);
        return player;
    }

    public Player updatePlayerSymbol(int id, String symbol) {
        Player player = getPlayerById(id);
        player.setSymbol(Symbol.getSymbolFromName(symbol.toUpperCase()));
        return player;
    }

    public Player getPlayerWinner(int botId, int playerId) {
        Player botPlayer = getPlayerById(botId);
        botPlayer.setSymbol(getRandomSymbol());
        Player realPlayer = getPlayerById(playerId);
        Player noPlayer = new Player(PlayerType.NONE);
        noPlayer.setName("No Player");
        int result = botPlayer.getSymbol().compareTo(realPlayer.getSymbol());
        return switch (result) {
            case Symbol.REAL_PLAYER_WINS -> realPlayer;
            case Symbol.BOT_PLAYER_WINS -> botPlayer;
            default -> noPlayer;
        };
    }

    private Symbol getRandomSymbol() {
        int randomInt = random.nextInt(SymbolValue.values().length);
        SymbolValue symbolValue = SymbolValue.getSymbolValueFromId(randomInt);
        return getSymbolFromName(symbolValue.name());
    }

    private Symbol getSymbolFromName(String symbolName) {
        return Symbol.getSymbolFromName(symbolName);
    }

}
