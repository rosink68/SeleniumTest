package de.msg.erstetests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RechnenklasseTest {

    @Test
    @DisplayName("Teste Addition mit zwei Werten")
    void testeAdditionMitZweiWerten() {
        Assertions.assertEquals(4, Rechnenklasse.addieren(2,2));
    }

    @Test
    @DisplayName("Teste Addition mit drei Werten")
    void testeAdditionMitDreiWerten() {
        Assertions.assertEquals(1700, Rechnenklasse.addieren(-5250, 7000, -50));
    }
}
