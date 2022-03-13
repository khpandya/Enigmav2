package com.enigma.modelTest;

import com.enigma.model.Casing;
import org.junit.jupiter.api.Test;

class CasingTest {

    @Test
    void getOutput() {
        // single character reflection test
        Casing c = new Casing();
        String x = c.getOutput("C");
        Casing c2 = new Casing();
        assert "C".equals(c2.getOutput(x));
    }

    @Test
    void setReflector() {
    }

    @Test
    void setRotor() {
    }
}