package com.enigma;


import com.enigma.model.EnigmaMachine;
import com.enigma.model.IModel;

public class RoughTest {
    public static void encryptionReversalTest() {
        IModel model = new EnigmaMachine();
        String encrypted = model.getEncryptedMessage("cat");
        System.out.println(encrypted);
        model.resetToDefaultSettings();
        String decrypted = model.getEncryptedMessage(encrypted);
        System.out.println(decrypted);
        assert decrypted == "CAT";
    }

    public static void rotorTest() {

    }

    public static void main(String[] args) {
        // Test
       encryptionReversalTest();

    }
}