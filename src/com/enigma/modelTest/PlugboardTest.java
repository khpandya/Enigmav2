package com.enigma.modelTest;

import com.enigma.model.Plugboard;
import org.junit.jupiter.api.Test;

class PlugboardTest {

    @Test
    void getOutput() {
        Plugboard pb = new Plugboard();
        assert "CAT".equals(pb.getOutput("CAT"));
    }

    @Test
    void addConnection() {
        Plugboard pb = new Plugboard();
        pb.addConnection('A','C');
        assert "ACT".equals(pb.getOutput("CAT"));
        pb.addConnection('A','T');
        assert "CTA".equals(pb.getOutput("CAT"));
    }

    @Test
    void deleteConnection() {
        Plugboard pb = new Plugboard();
        pb.addConnection('A','C');
        assert "ACT".equals(pb.getOutput("CAT"));
        pb.deleteConnection('A');
        pb.deleteConnection('T');
        assert "CAT".equals(pb.getOutput("CAT"));
    }
}