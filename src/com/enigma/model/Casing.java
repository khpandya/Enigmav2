package com.enigma.model;

import com.enigma.Reflectors;
import com.enigma.Rotors;

import java.util.ArrayList;

public class Casing {
    private Reflector reflector;
    // 0 represents the left-most and slowest rotor
    private ArrayList<Rotor> rotors = new ArrayList<>();
    // infiniteCounter is used to decide if a rotor should rotate, note that a rotor's numeric position is totally unrelated
    // Note on a behavioural decision here:
    // the casing is state-less i.e. each single 'encryption' is treated independently
    // to get a state like observation of the machine you can pass in a large string to encrypt.
    // Once an encryption has been done, the 'memory' of an upcoming rotation is wiped - so if you encrypted a 25 letter
    // string and a rotor to the left was about to rotate on the next iteration - no such thing will happen and to
    // encounter such a rotation you will have to encrypt a string >25 letters at once.
    // such a decision is necessary to remove the ambiguity of what changing a rotor-slider on a GUI means as a physical
    // action - is it removing a rotor and then putting it back at a desired place or is it rotating it inside the machine
    // (thus possibly affecting the rotors to its left) - in this case we chose the former.
    private int infiniteCounter = 1;

    public Casing() {
        setReflector(Reflectors.ReflectorA);
        for (int i=0; i<3; i++) {
            Rotor r = new Rotor(Rotors.RotorA);
            rotors.add(r);
        }
    }

    public void changeRotorPosition(int rotorIndex, int newPosition) {
        if (rotorIndex < 0 || rotorIndex > rotors.size()-1 || newPosition < 1 || newPosition > 26) {
            return;
        }
        while(rotors.get(rotorIndex).getNumericPosition() != newPosition) {
            // manual rotation (changing slider) is like taking out the rotor and putting it back in at a certain
            // position, so we don't call executeRotorMotion() to rotate ones to the left
            rotors.get(rotorIndex).Rotate();
            infiniteCounter = 1;
        }
    }

    public ArrayList<Integer> getRotorPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i=0; i < rotors.size(); i++) {
            positions.add(rotors.get(i).getNumericPosition());
        }
        return positions;
    }

    public String getOutput(String input) {
        infiniteCounter = 1;
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char out = getOutput(c);
            output += String.valueOf(out);
        }
        return output;
    }

    private void executeRotorMotion() {
        // rightmost always rotates
        rotors.get(rotors.size()-1).Rotate();
        infiniteCounter += 1;
        // others rotate at multiples of 26^reverseRotorIndex
        for (int i = rotors.size() - 2; i >= 0; i--) {
            int reverseRotorIndex = rotors.size() - (i+1);
            if (infiniteCounter%Math.pow(26,reverseRotorIndex) == 0){
                rotors.get(i).Rotate();
            }
        }
    }

    private char getOutput(char inputChar) {
        char outputChar = inputChar;
        for (int i = rotors.size() - 1; i >= 0; i--) {
            Rotor rotor = rotors.get(i);
            outputChar = rotor.getOutput(String.valueOf(outputChar)).charAt(0);
        }
        outputChar = reflector.getOutput(String.valueOf(outputChar)).charAt(0);
        for (int i = 0; i < rotors.size(); i++) {
            Rotor rotor = rotors.get(i);
            outputChar = rotor.getInverseOutput(String.valueOf(outputChar)).charAt(0);
        }
        executeRotorMotion();
        return outputChar;
    }

    public void setReflector(Reflectors reflectorName) {
        this.reflector = new Reflector(reflectorName);
    }

    public void setRotor(int index, Rotors rotorName) {
        Rotor rotor = new Rotor(rotorName);
        rotors.set(index, rotor);
    }
}
