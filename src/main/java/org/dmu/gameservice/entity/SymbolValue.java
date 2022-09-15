package org.dmu.gameservice.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Der Wert eines {@link Symbol Symbols}
 * und dessen Gegner.
 * @see SymbolValue#ordinal()
 */
public enum SymbolValue {

    STONE(List.of(2, 3)),
    SCISSORS(List.of(0, 3)),
    PAPER(List.of(1)),
    FOUNTAIN(List.of(2));

    final List<Integer> opponents;

    SymbolValue(List<Integer> opponents) {
        this.opponents = opponents;
    }

    public static SymbolValue getSymbolValueFromId(int id) {
        return Arrays.stream(SymbolValue.values())
                .filter(value -> value.ordinal() == id)
                .findFirst()
                .orElseThrow();
    }
}
