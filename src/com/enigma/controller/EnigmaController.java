package com.enigma.controller;

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
        enigmaView.addEncryptListener(new EncryptionListener());
        enigmaView.addResetListener(new ResetListener());
        enigmaView.addConnectListener(new connectListener());
        enigmaView.addDeleteListener(new deleteListener());
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
            enigmaModel.resetToDefaultSettings();
            enigmaView.setOutput("");
            enigmaView.resetRotors();
            enigmaView.resetPlugboard();
        }
    }

    class EncryptionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = enigmaView.getInput();
            ArrayList<Integer> rotorPositions = enigmaView.getRotorValues();
            try {
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
