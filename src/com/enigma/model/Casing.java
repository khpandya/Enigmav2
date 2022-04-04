package com.enigma.model;

import com.enigma.Reflectors;
import com.enigma.Rotors;

import java.util.ArrayList;

public class Casing {
    private Reflector reflector;
    // 0 represents the left-most and slowest rotor
    private ArrayList<Rotor> rotors = new ArrayList<>();
    private ArrayList<Integer> counters = new ArrayList<>();

    public Casing() {
        setReflector(Reflectors.ReflectorA);
        for (int i=0; i<3; i++) {
            Rotor r = new Rotor(Rotors.RotorA);
            rotors.add(r);
            counters.add(1);
        }
    }

    public void changeRotorPosition(int rotorIndex, int newPosition) {
        if (rotorIndex < 0 || rotorIndex > rotors.size()-1 || newPosition < 1 || newPosition > 26) {
            return;
        }
        while(rotors.get(rotorIndex).getNumericPosition() != newPosition) {
            rotors.get(rotorIndex).Rotate();
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
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char out = getOutput(c);
            output += String.valueOf(out);
        }
        return output;
    }

    private void executeRotorMotion() {
        rotors.get(rotors.size()-1).Rotate();
        counters.set(counters.size()-1, counters.get(counters.size()-1)+1);
        for (int i = rotors.size() - 2; i >= 0; i--) {
            if (counters.get(i)%26 == 0){
                rotors.get(i).Rotate();
                counters.set(i,counters.get(i)+1);
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
            // TODO read left-to-right mapping not right-to-left. Make letter-mapping a bimap.
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
