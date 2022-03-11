package com.enigma.model;

import com.enigma.Reflectors;
import com.enigma.Rotors;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class Reflector extends LetterMapping{
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

    Reflector(Reflectors reflectorName){
        List<Character> initialMap = getConstantMapping(reflectorName);
        int counter = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++){
            mapping.put(ch, initialMap.get(counter));
        }
    }

    private @NotNull
    List<Character> getConstantMapping(@NotNull Reflectors reflectorName) {
        switch (reflectorName){
            case ReflectorA:
                return Arrays.asList('A');
            case ReflectorB:
                return Arrays.asList('K');
            default:
                return Arrays.asList('M');
        }
    }
}
