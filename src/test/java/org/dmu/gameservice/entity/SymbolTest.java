package org.dmu.gameservice.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testet die Funktionalität des {@link Symbol Symbols}.
 * Diese Methoden {@link Symbol#getSymbolFromName(String) getSymbolFromName}
 * und {@link Symbol#compareTo(Symbol) compareTo}
 * sind grundlegend wichtig für die Logik des Spiels
 */
class SymbolTest {

    Symbol stoneSymbol;
    Symbol scissorsSymbol;
    Symbol paperSymbol;
    Symbol fountainSymbol;

    @BeforeEach
    void init() {
        stoneSymbol = Symbol.getSymbolFromName(SymbolValue.STONE.name());
        scissorsSymbol = Symbol.getSymbolFromName(SymbolValue.SCISSORS.name());
        paperSymbol = Symbol.getSymbolFromName(SymbolValue.PAPER.name());
        fountainSymbol = Symbol.getSymbolFromName(SymbolValue.FOUNTAIN.name());
    }

    @Test
    void testGetSymbolFromId() {
        assertEquals(SymbolValue.STONE, stoneSymbol.getSymbolValue());
        assertEquals(SymbolValue.SCISSORS, scissorsSymbol.getSymbolValue());
        assertEquals(SymbolValue.PAPER, paperSymbol.getSymbolValue());
        assertEquals(SymbolValue.FOUNTAIN, fountainSymbol.getSymbolValue());
    }

    @Test
    void testCompareSymbol() {
        assertEquals(0, stoneSymbol.compareTo(stoneSymbol));
        assertEquals(1, stoneSymbol.compareTo(scissorsSymbol));
        assertEquals(-1, stoneSymbol.compareTo(paperSymbol));
        assertEquals(-1, stoneSymbol.compareTo(fountainSymbol));

        assertEquals(0, scissorsSymbol.compareTo(scissorsSymbol));
        assertEquals(1, scissorsSymbol.compareTo(paperSymbol));
        assertEquals(-1, scissorsSymbol.compareTo(stoneSymbol));
        assertEquals(-1, scissorsSymbol.compareTo(fountainSymbol));

        assertEquals(0, paperSymbol.compareTo(paperSymbol));
        assertEquals(1, paperSymbol.compareTo(stoneSymbol));
        assertEquals(1, paperSymbol.compareTo(fountainSymbol));
        assertEquals(-1, paperSymbol.compareTo(scissorsSymbol));

        assertEquals(0, fountainSymbol.compareTo(fountainSymbol));
        assertEquals(1, fountainSymbol.compareTo(stoneSymbol));
        assertEquals(1, fountainSymbol.compareTo(scissorsSymbol));
        assertEquals(-1, fountainSymbol.compareTo(paperSymbol));
    }
}
