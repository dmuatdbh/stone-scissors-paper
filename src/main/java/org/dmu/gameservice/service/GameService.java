package org.dmu.gameservice.service;

import org.dmu.gameservice.entity.Player;
import org.dmu.gameservice.entity.Symbol;
import org.dmu.gameservice.entity.SymbolValue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Service Implementierung des Spiels.
 * Hält die List von {@link Player Spielern}.
 */
@Service
public class GameService {

    private final static int BOT_PLAYER_ID = 1;
    private final static int REAL_PLAYER_ID = 2;
    private final static int NO_PLAYER_ID = 3;
    private final Random random = new Random();
    private final Collection<Player> players;

    public GameService() {
        players = new ArrayList<>();
        Player botPlayer = new Player(BOT_PLAYER_ID);
        botPlayer.setName("Bot Player");
        Player realPlayer = new Player(REAL_PLAYER_ID);
        players.addAll(List.of(botPlayer, realPlayer));
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

    public Player getPlayerWinner() {
        Player botPlayer = getPlayerById(BOT_PLAYER_ID);
        botPlayer.setSymbol(getRandomSymbol());
        Player realPlayer = getPlayerById(REAL_PLAYER_ID);
        Player noPlayer = new Player(NO_PLAYER_ID);
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
