package com.enigma.modelTest;

import com.enigma.model.Casing;
import org.junit.jupiter.api.Test;

class CasingTest {
    private String getStringOfLength(int length) {
        String out = "";
        for (int i = 0; i < length; i++) {
            out += "A";
        }
        return out;
    }

    @Test
    void rotationTest() {
        // TODO
        Casing c = new Casing();
        System.out.println(c.getRotorPositions());
        c.getOutput(getStringOfLength(26*26*25));
        System.out.println(c.getRotorPositions());
        c.getOutput("A");
        System.out.println(c.getRotorPositions());
        c.getOutput(getStringOfLength(34));
        System.out.println(c.getRotorPositions());
    }

    @Test
    void getOutput() {
        // single character reflection test
        Casing c = new Casing();
        String x = c.getOutput("C");
        c.changeRotorPosition(2,1);
        assert "C".equals(c.getOutput(x));
        // string reflection test
        String x2 = c.getOutput("ABRACADABRA");
        c.changeRotorPosition(2,2);
        assert "ABRACADABRA".equals(c.getOutput(x2));
        // character reflection test after multi-rotor movement
        c.changeRotorPosition(0,4);
        c.changeRotorPosition(1,26);
        c.changeRotorPosition(2,13);
        String x3 = c.getOutput("C");
        c.changeRotorPosition(0,4);
        c.changeRotorPosition(1,26);
        c.changeRotorPosition(2,13);
        assert "C".equals(c.getOutput(x3));
        // string reflection test after multi-rotor movement
        c.changeRotorPosition(0,26);
        c.changeRotorPosition(1,26);
        c.changeRotorPosition(2,26);
        String x4 = c.getOutput("ABRACADABRA");
        c.changeRotorPosition(0,26);
        c.changeRotorPosition(1,26);
        c.changeRotorPosition(2,26);
        assert "ABRACADABRA".equals(c.getOutput(x4));
    }

    @Test
    void setReflector() {
    }

    @Test
    void setRotor() {
    }
}