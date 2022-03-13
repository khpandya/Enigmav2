package com.enigma.model;

import com.enigma.Rotors;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class Rotor extends LetterMapping{
    public Rotor(Rotors rotorName){
        List<String> initialMap = getConstantMapping(rotorName);
        int counter = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++){
            mapping.put(ch, initialMap.get(counter).charAt(0));
            counter += 1;
        }
    }

    public void Rotate(){
        char chAtA = mapping.get('A');
        for (char ch = 'B'; ch <= 'Z'; ch++){
            char trailingChar = (char) (ch-1);
            mapping.replace(trailingChar, mapping.get(ch));
        } // A gets B, B gets C...Y gets Z
        mapping.replace('Z',chAtA);
    }

    /**
     * @param input the character input into the component
     * @return the character that's mapped to the input
     */
    @Override
    public String getOutput(@NotNull String input) {
        if (input.charAt(0) < 'A' || input.charAt(0) > 'Z') {
            return input;
        }
        return String.valueOf(mapping.get(input.charAt(0)));
    }

    private @NotNull
    List<String> getConstantMapping(@NotNull Rotors rotorName) {
        return switch (rotorName) {
            case RotorA -> Arrays.asList("VEOSIRZUJDQCKGWYPNXAFLTHMB".split(""));
            case RotorB -> Arrays.asList("UEMOATQLSHPKCYFWJZBGVXINDR".split(""));
            default -> Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        };
    }
}
