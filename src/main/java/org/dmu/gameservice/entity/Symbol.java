package org.dmu.gameservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Das Symbol hat einen {@link SymbolValue Wert} und hält die Vergleichs-Logik
 * zum Ermitteln eines Gewinners.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Symbol implements Comparable<Symbol>{

    public final static int BOT_PLAYER_WINS = 1;
    public final static int REAL_PLAYER_WINS = -1;
    public final static int NO_PLAYER_WINS = 0;
    private final SymbolValue symbolValue;

    /**
     * Liefert ein Symbol anhand eines Namens
     * @param symbolName Name des Symbols
     * @return das Symbol mit gesuchtem Namen
     * @throws IllegalArgumentException Tritt auf wenn der Name nicht existiert.
     */
    public static Symbol getSymbolFromName(String symbolName) throws IllegalArgumentException {
        return new Symbol(SymbolValue.valueOf(symbolName));
    }

    /**
     * Vergleichslogik für zwei {@link Symbol Symoble}
     */
    @Override
    public int compareTo(Symbol symbol) {
        if (this.getOpponents().contains(symbol)) {
            return REAL_PLAYER_WINS;
        }
        if (this.equals(symbol)) {
            return NO_PLAYER_WINS;
        }
        return BOT_PLAYER_WINS;
    }

    private List<Symbol> getOpponents() {
        List<Symbol> opponents = new ArrayList<>();
        symbolValue.opponents
                .forEach(integer -> opponents.add(new Symbol(SymbolValue.getSymbolValueFromId(integer))));
        return opponents;
    }

    @Override
    public String toString() {
        return this.symbolValue.name();
    }
}
