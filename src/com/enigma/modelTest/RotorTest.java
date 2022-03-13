package com.enigma.modelTest;

import com.enigma.Rotors;
import com.enigma.model.Rotor;
import org.junit.jupiter.api.Test;

class RotorTest {

    @Test
    void rotate() {
        Rotor r = new Rotor(Rotors.RotorA);
        r.Rotate();
        assert "E".equals(r.getOutput("A"));
        assert "O".equals(r.getOutput("B"));
        assert "V".equals(r.getOutput("Z"));
        Rotor r2 = new Rotor(Rotors.RotorB);
        r2.Rotate();
        assert "E".equals(r2.getOutput("A"));
        assert "M".equals(r2.getOutput("B"));
        assert "U".equals(r2.getOutput("Z"));
    }

    @Test
    void getOutput() {
        Rotor r = new Rotor(Rotors.RotorA);
        assert "V".equals(r.getOutput("A"));
        assert "E".equals(r.getOutput("B"));
        assert "O".equals(r.getOutput("C"));
        Rotor r2 = new Rotor(Rotors.RotorB);
        assert "U".equals(r2.getOutput("A"));
        assert "E".equals(r2.getOutput("B"));
        assert "M".equals(r2.getOutput("C"));
        assert "*".equals(r2.getOutput("*"));
    }
}