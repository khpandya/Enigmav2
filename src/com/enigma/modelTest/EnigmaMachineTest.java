package com.enigma.modelTest;

import com.enigma.model.EnigmaMachine;
import com.enigma.model.IModel;

class EnigmaMachineTest {

    @org.junit.jupiter.api.Test
    void getEncryptedMessage() {
        IModel model = new EnigmaMachine();
        String encrypted = model.getEncryptedMessage("cat");
        model.resetToDefaultSettings();
        String decrypted = model.getEncryptedMessage(encrypted);
        assert "CAT".equals(decrypted);
    }

    @org.junit.jupiter.api.Test
    void setRotor() {
    }

    @org.junit.jupiter.api.Test
    void setReflector() {
    }

    @org.junit.jupiter.api.Test
    void createPlugboardConnection() {
    }

    @org.junit.jupiter.api.Test
    void deletePlugboardConnection() {
    }

    @org.junit.jupiter.api.Test
    void resetPlugboard() {
    }

    @org.junit.jupiter.api.Test
    void resetCasing() {
    }

    @org.junit.jupiter.api.Test
    void resetToDefaultSettings() {
    }
}