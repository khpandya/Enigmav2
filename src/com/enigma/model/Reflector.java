package com.enigma.model;

import com.enigma.Reflectors;
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
        return String.valueOf(mapping.get(input.charAt(0)));
    }

    public Reflector(Reflectors reflectorName){
        List<String> initialMap = getConstantMapping(reflectorName);
        int counter = 0;
        for (char ch = 'A'; ch <= 'Z'; ch++){
            mapping.put(ch, initialMap.get(counter).charAt(0));
            counter += 1;
        }
    }

    private @NotNull
    List<String> getConstantMapping(@NotNull Reflectors reflectorName) {
        return switch (reflectorName) {
            case ReflectorA -> Arrays.asList("VEOSIRZUJDQCKGWYPNXAFLTHMB".split(""));
            case ReflectorB -> Arrays.asList("UEMOATQLSHPKCYFWJZBGVXINDR".split(""));
            default -> Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        };
    }
}
