package de.msg.erstetests;

import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
public class Testmethoden {

    @BeforeAll
    public static void start () {
        System.out.println("Aktionen beim Starten");
    }

    @BeforeEach
    public void vorJederMethode() {
//        System.out.println("vor jeder Methode");
    }

    @AfterAll
    public static void beenden() {
        System.out.println("Aktionen beim Beenden");
    }

    @Test
    public void objekteGleichheitTest() {

        String erwartet = "ModelMyMind";
        String tatsaechlich = "ModelMyMind";

        Assertions.assertSame(erwartet, tatsaechlich);
    }

    @Test
    public void objektNichtGleichTest() {
        Object katze = new Object();
        Object hund = new Object();

        Assertions.assertNotSame(katze, hund);
    }

    @Test
    public void nullTest() {

        String nullString = null;

        Assertions.assertNull(nullString, "Das Objekt sollte null sein.");
    }

    @Test
    public void nichtNullTest() {
        String vorname = "Karl";

        Assertions.assertNotNull(vorname, "Der Vorname ist null.");
    }

    @Test
    public void exceptionTest() {

        Object testObjekt = null;

        Assertions.assertThrows(NullPointerException.class, () -> testObjekt.getClass());
    }

    private static double [][] liefereArray() {
        return new double[][] {{1.0, 2.0, 3.0}, {5.0, 3.0, 8.0}, {121.0, 4.0, 125.0}};
    }

/**
    @ParameterizedTest
    @MethodSource(value = "liefereArray")
    public void mitParameterTest(double[] daten) {

        double n1 = daten[0];
        double n2 = daten[1];

        double erwartet = daten[2];

        Assertions.assertEquals(erwartet, Rechnenklasse.addieren(n1, n2));
    }
*/
}
