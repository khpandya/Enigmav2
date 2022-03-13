package com.enigma.modelTest;

import com.enigma.Reflectors;
import com.enigma.model.Reflector;
import org.junit.jupiter.api.Test;

class ReflectorTest {

    @Test
    void getOutput() {
        Reflector r = new Reflector(Reflectors.ReflectorA);
        assert "V".equals(r.getOutput("A"));
        assert "B".equals(r.getOutput("Z"));
        Reflector r2 = new Reflector(Reflectors.ReflectorB);
        assert "U".equals(r2.getOutput("A"));
        assert "R".equals(r2.getOutput("Z"));
    }
}