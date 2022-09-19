package org.dmu.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Ein Spieler-Objekt besteht aus einer eindeutigen id, dem Namen und einem Symbol
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Player {

    public Player(PlayerType type) {
        this.type = type;
    }

    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType type;

    @Override
    public String toString() {
        return name + ": " + symbol + "\n";
    }
}
