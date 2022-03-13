package com.enigma.modelTest;

import com.enigma.Reflectors;
import com.enigma.model.Reflector;
import org.junit.jupiter.api.Test;

class ReflectorTest {

    @Test
    void getOutput() {
        Reflector r = new Reflector(Reflectors.ReflectorA);
        String x = r.getOutput("A");
        assert "A".equals(r.getOutput(x));
        String y = r.getOutput("Z");
        assert "Z".equals(r.getOutput(y));
        Reflector r2 = new Reflector(Reflectors.ReflectorB);
        String x2 = r2.getOutput("A");
        assert "A".equals(r2.getOutput(x2));
        String y2 = r2.getOutput("Z");
        assert "Z".equals(r2.getOutput(y2));
        assert "*".equals(r2.getOutput("*"));
    }
}