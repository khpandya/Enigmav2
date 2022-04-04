package com.enigma.model;

import com.enigma.Reflectors;
import com.enigma.Rotors;

import java.util.ArrayList;

public class EnigmaMachine implements IModel {
    private Plugboard plugboard = new Plugboard();
    private Casing casing = new Casing();

    @Override
    public String getEncryptedMessage(String input) {
        input = input.toUpperCase();
        String plugboardOutput = plugboard.getOutput(input);
        String casingOutput = casing.getOutput(plugboardOutput);
        return plugboard.getOutput(casingOutput);
    }

    @Override
    public void setRotor(int index, Rotors rotorName) {
        casing.setRotor(index, rotorName);
    }

    /**
     * rotates a rotor at index until it is at 'newPosition'
     *
     * @param index
     * @param newPosition
     */
    @Override
    public void changeRotorPosition(int index, int newPosition) {
        casing.changeRotorPosition(index, newPosition);
    }

    @Override
    public ArrayList<Integer> getRotorPositions() {
        return casing.getRotorPositions();
    }

    @Override
    public void setReflector(Reflectors reflectorName) {
        casing.setReflector(reflectorName);
    }

    /**
     * connects two letters on the plugboard. Deletes existing connections if necessary to create a new connection.
     * @param letterOne letter to be connected to letterTwo
     * @param letterTwo letter to be connected to letterOne
     */
    @Override
    public void createPlugboardConnection(char letterOne, char letterTwo) {
        plugboard.addConnection(letterOne, letterTwo);
    }

    /**
     * deletes plugboard connection involving the letter passed in
     * @param letter letter whose connection is to be deleted
     */
    @Override
    public void deletePlugboardConnection(char letter) {
        plugboard.deleteConnection(letter);
    }

    /**
     * deletes all connections present on the plugboard
     */
    @Override
    public void resetPlugboard() {
        this.plugboard = new Plugboard();
    }

    public void resetCasing() {
        this.casing = new Casing();
    }

    /**
     * deletes all connections on the plugboard
     */
    @Override
    public void resetToDefaultSettings() {
        resetPlugboard();
        resetCasing();
    }
}
