package com.enigma.model;

public class EnigmaMachine implements IModel {
    private Plugboard plugboard;
    private Casing casing;

    @Override
    public String getEncryptedMessage(String input) {
        // TODO all caps, remove invalid characters
        String plugboardOutput = plugboard.getOutput(input);
        String casingOutput = casing.getOutput(plugboardOutput);
        return plugboard.getOutput(casingOutput);
    }

    @Override
    public void setRotor(String rotorPosition, String rotorName) {

    }

    @Override
    public void setReflector(String reflectorName) {

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

    @Override
    public void resetRotors() {

    }

    /**
     * deletes all connections present on the plugboard
     */
    @Override
    public void resetPlugboard() {
        this.plugboard = new Plugboard();
    }

    /**
     * deletes all connections on the plugboard
     */
    @Override
    public void resetToDefaultSettings() {
        resetPlugboard();
        this.casing = new Casing();
    }
}
