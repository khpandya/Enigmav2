package com.enigma.model;

import com.enigma.Reflectors;
import com.enigma.Rotors;
import com.google.common.collect.BiMap;

import java.util.ArrayList;

public interface IModel {
    String getEncryptedMessage(String input);

    /**
     * puts a rotor into the specified position with default starting point
     * @param rotorPosition
     * @param rotorName
     */
    void setRotor(int rotorPosition, Rotors rotorName);

    /**
     * rotates a rotor at index until it is at 'newPosition'
     * @param index
     * @param newPosition
     */
    void changeRotorPosition(int index, int newPosition);
    ArrayList<Integer> getRotorPositions();
    void setReflector(Reflectors reflectorName);
    void createPlugboardConnection(char letterOne, char letterTwo);
    void deletePlugboardConnection(char letter);
    BiMap<Character, Character> getPlugboard();
    void resetPlugboard();
    void resetCasing();
    void resetToDefaultSettings();
}
