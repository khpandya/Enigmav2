package com.enigma.model;

import java.util.HashMap;

/**
 * LetterMapping represents a one-to-one mapping of the alphabet with a hashmap
 */
public abstract class LetterMapping {
    protected HashMap<Character, Character> mapping = new HashMap<Character, Character>();

    /**
     * @param input the character input into the component
     * @return the character that's mapped to the input
     */
    public abstract String getOutput(String input);

    /**
     * the constructor creates uppercase alphabet keys for the map and maps it to an empty string
     */
    LetterMapping(){
        for (char ch = 'A'; ch <= 'Z'; ++ch)
            mapping.put(ch, '*');
    }
}
