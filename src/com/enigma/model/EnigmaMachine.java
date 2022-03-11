package com.enigma.model;

public class EnigmaMachine implements IModel {
    private Plugboard plugboard;
    private Casing casing;
    @Override
    public String getEncryptedMessage(String input) {
        return null;
    }

    @Override
    public void setRotor(String rotorPosition, String rotorName) {

    }

    @Override
    public void setReflector(String reflectorName) {

    }

    @Override
    public void createPlugboardConnection(char letterOne, char letterTwo) {

    }

    @Override
    public void deletePlugboardConnection(char letter) {

    }

    @Override
    public void resetRotors() {

    }

    @Override
    public void resetPlugboard() {

    }

    @Override
    public void resetToDefaultSettings() {

    }
}
