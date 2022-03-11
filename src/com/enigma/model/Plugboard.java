package com.enigma.model;

public class Plugboard extends LetterMapping{
    /**
     * @param input the characters input into the plugboard
     * @return the output after replacing characters according to plugboard mapping
     */
    @Override
    public String getOutput(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String charOut = String.valueOf(mapping.get(c));
            // * means no connection
            if (charOut != "*") {
                output += charOut;
            }
            else {
                output += c;
            }
        }
        return output;
    }

    private boolean invalidLetter(char letter) {
        if (letter < 'A' || letter > 'Z') {
            return true;
        }
        return false;
    }

    /**
     * connects two letters on the plugboard. Deletes existing connections if necessary to create a new connection.
     * @param letterOne letter to be connected to letterTwo
     * @param letterTwo letter to be connected to letterOne
     */
    public void addConnection(char letterOne, char letterTwo) {
        if (invalidLetter(letterOne) || invalidLetter(letterTwo)) {
            return;
        }
        deleteConnection(letterOne);
        deleteConnection(letterTwo);
        mapping.replace(letterOne,letterTwo);
        mapping.replace(letterTwo,letterOne);
    }

    /**
     * deletes plugboard connection involving the letter passed in
     * @param letter letter whose connection is to be deleted
     */
    public void deleteConnection(char letter) {
        if (invalidLetter(letter)){
            return;
        }

        char connectedTo = mapping.get(letter);
        if (connectedTo != '*') {
            mapping.replace(connectedTo, '*');
        }

        mapping.replace(letter,'*');
    }
}
