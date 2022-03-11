package com.enigma.model;

import com.enigma.Rotors;

import java.util.Arrays;
import java.util.List;

public class Rotor extends LetterMapping{
    Rotor(Rotors rotorName){
        List<Character> initialMap = getConstantMapping(rotorName);
        int counter = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++){
            mapping.put(ch, initialMap.get(counter));
        }
    }

    public void Rotate(){
        char chAtA = mapping.get('A');
        for (char ch = 'B'; ch <= 'Z'; ch++){
            char trailingChar = (char) (ch-1);
            mapping.replace(trailingChar,ch);
        } // A gets B, B gets C...Y gets Z
        mapping.replace('Z',chAtA);
    }

    /**
     * @param input the character input into the component
     * @return the character that's mapped to the input
     */
    @Override
    public String getOutput(String input) {
        return String.valueOf(mapping.get(input));
    }

    private List<Character> getConstantMapping(Rotors rotorName) {
        switch (rotorName){
            case RotorA:
                return Arrays.asList('A');
            case RotorB:
                return Arrays.asList('K');
            default:
                return Arrays.asList('M');
        }
    }
}
