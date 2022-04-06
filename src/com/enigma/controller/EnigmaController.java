package com.enigma.controller;

import com.enigma.Reflectors;
import com.enigma.Rotors;
import com.enigma.model.IModel;
import com.enigma.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnigmaController {
    private IModel enigmaModel;
    private IView enigmaView;

    public EnigmaController(IModel model, IView view) {
        this.enigmaModel = model;
        this.enigmaView = view;
        enigmaView.addResetListener(new ResetListener());
        enigmaView.addEncryptListener(new EncryptionListener());
        enigmaView.addConnectListener(new connectListener());
        enigmaView.addDeleteListener(new deleteListener());
    }

    private Rotors stringToRotor(String rotorName) {
        switch (rotorName){
            case "Rotor B": return Rotors.RotorB;
            case "Rotor C": return Rotors.RotorC;
            default: return Rotors.RotorA;
        }
    }

    private Reflectors stringToReflector(String reflectorName) {
        switch (reflectorName){
            case "Reflector B": return Reflectors.ReflectorB;
            case "Reflector C": return Reflectors.ReflectorC;
            default: return Reflectors.ReflectorA;
        }
    }

    class deleteListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(enigmaView.getLetterToDelete().length() != 1) {
                    throw new Exception("0 or more than 1 characters entered");
                }
                enigmaModel.deletePlugboardConnection(enigmaView.getLetterToDelete().charAt(0));
                enigmaView.updatePlugboard(enigmaModel.getPlugboard());
            }
            catch (Exception ex) {
                enigmaView.displayError("check letter input");
            }
        }
    }

    class connectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if(enigmaView.getLetterOne().length() != 1 || enigmaView.getLetterTwo().length() != 1) {
                    throw new Exception("0 or more than 1 characters entered");
                }
                enigmaModel.createPlugboardConnection(enigmaView.getLetterOne().charAt(0),enigmaView.getLetterTwo().charAt(0));
                enigmaView.updatePlugboard(enigmaModel.getPlugboard());
            }
            catch (Exception ex) {
                enigmaView.displayError("check letter input");
            }
        }
    }

    class ResetListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                enigmaModel.resetToDefaultSettings();
                enigmaView.setOutput("");
                enigmaView.resetRotorPositions();
                enigmaView.resetPlugboard();
                enigmaView.resetRotorsAndReflector();
            }
            catch (Exception ex) {
                enigmaView.displayError("error resetting");
            }

        }
    }

    class EncryptionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = enigmaView.getInput();
            ArrayList<Integer> rotorPositions = enigmaView.getRotorValues();
            try {
                enigmaModel.setReflector(stringToReflector(enigmaView.getReflector()));
                enigmaModel.setRotor(0, stringToRotor(enigmaView.getRotor1()));
                enigmaModel.setRotor(1, stringToRotor(enigmaView.getRotor2()));
                enigmaModel.setRotor(2, stringToRotor(enigmaView.getRotor3()));
                for(int i = 0; i < rotorPositions.size(); i++) {
                    enigmaModel.changeRotorPosition(i, rotorPositions.get(i));
                }
                String output = enigmaModel.getEncryptedMessage(input);
                enigmaView.setOutput(output);
                enigmaView.setRotorPositions(enigmaModel.getRotorPositions());
            }
            catch (Exception ex) {
                System.out.println(ex);
                enigmaView.displayError("encryption error");
            }
        }
    }
}
