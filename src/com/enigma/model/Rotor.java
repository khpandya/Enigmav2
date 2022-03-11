package com.enigma.model;

import com.enigma.Rotors;
import org.jetbrains.annotations.NotNull;

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
            mapping.replace(trailingChar,mapping.get(ch));
        } // A gets B, B gets C...Y gets Z
        mapping.replace('Z',chAtA);
    }

    /**
     * @param input the character input into the component
     * @return the character that's mapped to the input
     */
    @Override
    public String getOutput(String input) {
        if (input.charAt(0) < 'A' || input.charAt(0) > 'Z') {
            return input;
        }
        return String.valueOf(mapping.get(input));
    }

    private @NotNull
    List<Character> getConstantMapping(@NotNull Rotors rotorName) {
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
