package com.enigma.model;

public interface IModel {
    // TODO update these, methods may look different, types shouldn't be string but rather actual rotor objects etc.
    // controller should be translating string to rotor objects and passing these in
    String getEncryptedMessage(String input);
    void setRotor(String rotorPosition, String rotorName);
    void setReflector(String reflectorName);
    void createPlugboardConnection(char letterOne, char letterTwo);
    void deletePlugboardConnection(char letter);
    void resetRotors();
    void resetPlugboard();
    void resetToDefaultSettings();
}
