package org.dmu.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Ein Spieler-Objekt besteht aus einer eindeutigen id, dem Namen und einem Symbol
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Player {

    public Player(int id) {
        this.id = id;
    }

    private int id;
    private String name;
    private Symbol symbol;

    @Override
    public String toString() {
        return name + ": " + symbol + "\n";
    }
}
