package com.enigma;


import com.enigma.model.EnigmaMachine;
import com.enigma.model.IModel;

public class main {
    public static void main(String[] args) {
        // Test
        IModel model = new EnigmaMachine();
        String encrypted = model.getEncryptedMessage("cat");
        System.out.println(encrypted);
        model.resetToDefaultSettings();
        String decrypted = model.getEncryptedMessage(encrypted);
        System.out.println(decrypted);
    }
}