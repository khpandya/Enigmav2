package com.enigma.model;

import com.enigma.Reflectors;
import com.enigma.Rotors;

public interface IModel {
    String getEncryptedMessage(String input);
    void setRotor(int rotorPosition, Rotors rotorName);
    void setReflector(Reflectors reflectorName);
    void createPlugboardConnection(char letterOne, char letterTwo);
    void deletePlugboardConnection(char letter);
    void resetPlugboard();
    void resetCasing();
    void resetToDefaultSettings();
}
