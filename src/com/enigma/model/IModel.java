package com.enigma.model;

public interface IModel {
    String getEncryptedMessage(String input);
    void setRotor(String rotorPosition, String rotorName);
    void setReflector(String reflectorName);
    void createPlugboardConnection(char letterOne, char letterTwo);
    void deletePlugboardConnection(char letter);
    void resetRotors();
    void resetPlugboard();
    void resetToDefaultSettings();
}
