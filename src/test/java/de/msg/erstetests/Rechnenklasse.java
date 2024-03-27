package de.msg.erstetests;

import java.util.stream.DoubleStream;

public class Rechnenklasse {

    static double addieren(double... zahlen) {

        return DoubleStream.of(zahlen).sum();
    }

}
